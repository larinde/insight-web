import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import com.bmuschko.gradle.docker.tasks.image.Dockerfile
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage

group = "com.koweg.insight"

version = "0.0.1-SNAPSHOT"

//java.sourceCompatibility = JavaVersion.VERSION_1_8
java.sourceCompatibility = JavaVersion.VERSION_11

val deployArtifact = "insight-web.jar"

version = "0.0.1-SNAPSHOT"
//java.sourceCompatibility = JavaVersion.VERSION_1_8
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	mavenLocal()
}

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.7.10"
	kotlin("plugin.spring") version "1.7.10"
	id("com.netflix.dgs.codegen") version "5.2.4"
	//jacoco
}

extra["springCloudVersion"] = "2021.0.3"



dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.cloud:spring-cloud-stream")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")

	implementation("com.yahoofinance-api:YahooFinanceAPI:3.15.0")

	implementation("com.github.javafaker:javafaker:1.+")

	//implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:3.11.0"))
	implementation(platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:latest.release"))
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
	implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
	implementation("com.netflix.graphql.dgs:graphql-dgs-subscriptions-websockets-autoconfigure")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("com.jayway.jsonpath:json-path:2.2.0")
	testImplementation("io.mockk:mockk:1.11.0")
	testImplementation("org.assertj:assertj-core:3.19.0")
	testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test")
	//testImplementation("junit:junit:4.13.2")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

/**
jacoco {
	toolVersion = "0.8.8"
	reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
}

tasks.test{
	finalizedBy(tasks.jacocoTestReport)
}
*/

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		//jvmTarget = "1.8"
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<com.netflix.graphql.dgs.codegen.gradle.GenerateJavaTask> {
	generateClient = true
	packageName = "com.koweg.insight.domain.generated"
}

tasks.bootJar {
    archiveFileName.set("${deployArtifact}")
}

docker {
    //url.set("https://192.168.99.101:2376")
    //certPath.set(File(System.getProperty("user.home"), ".boot2docker/certs/boot2docker-vm"))
	url.set("tcp://192.168.99.101:2376")

//    registryCredentials {
//        url.set("https://index.docker.io/v1/")
//        username.set("larinde")
//        password.set("secret")
//        email.set("olarinde.ajai@gmail.com")
//    }
}

// https://docs.gradle.org/current/userguide/kotlin_dsl.html
val copyDeployArtifactForContainerisation by tasks.creating(Copy::class) {
    from("${project.buildDir}/libs/${deployArtifact}")
    into("${project.buildDir}/docker/")
}

val createDockerfile by tasks.creating(Dockerfile::class) {
    from("openjdk:jre-alpine")
    label(mapOf("maintainer" to "Olarinde Ajai 'olarinde.ajai@koweg.co.uk'"))
    copyFile("${deployArtifact}", "/app/${deployArtifact}")
    entryPoint("java")
    defaultCommand("-jar", "/app/${deployArtifact}")
    exposePort(7071)
}

tasks.create("buildImage", DockerBuildImage::class) {
    dependsOn(copyDeployArtifactForContainerisation)
    dependsOn(createDockerfile)
    images.add("koweg/insight-web:latest")
}
