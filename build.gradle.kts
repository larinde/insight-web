import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import com.bmuschko.gradle.docker.tasks.image.Dockerfile
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage

group = "com.koweg.insight"

version = "0.0.1-SNAPSHOT"

//java.sourceCompatibility = JavaVersion.VERSION_1_8
java.sourceCompatibility = JavaVersion.VERSION_11

val deployArtifact = "insight-web.jar"

repositories {
	mavenCentral()
	mavenLocal()
}

plugins {
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	id("org.springframework.boot") version "2.4.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.netflix.dgs.codegen") version "4.4.1"
    id("com.bmuschko.docker-remote-api") version "7.2.0"
	jacoco
}

extra["springCloudVersion"] = "2020.0.3"


extra["arrowVersion"] = "0.13.2"
extra["testcontainersVersion"] = "1.15.3"
dependencies {

	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.cloud:spring-cloud-stream")

	implementation("com.yahoofinance-api:YahooFinanceAPI:3.15.0")


	implementation(
		platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:4.3.1")
	)
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
	implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
	implementation("com.netflix.graphql.dgs:graphql-dgs-subscriptions-websockets-autoconfigure")

	implementation(
		platform("io.arrow-kt:arrow-stack:${property("arrowVersion")}")
	)
	implementation("io.arrow-kt:arrow-core")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.testcontainers:junit-jupiter")
	testImplementation("com.jayway.jsonpath:json-path:2.2.0")
	testImplementation("io.mockk:mockk:1.11.0")
	testImplementation("org.assertj:assertj-core:3.19.0")
}

dependencyManagement {
	imports {
		mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

jacoco {
	toolVersion = "0.8.7"
	reportsDirectory.set(layout.buildDirectory.dir("customJacocoReportDir"))
}

tasks.test{
	finalizedBy(tasks.jacocoTestReport)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
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
