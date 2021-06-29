import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "com.koweg.insight"



version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8
repositories {
	mavenCentral()
	mavenLocal()
}

extra["springCloudVersion"] = "2020.0.3"


extra["arrowVersion"] = "0.13.2"
extra["testcontainersVersion"] = "1.15.3"
dependencies {

	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-cache")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
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
		platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:3.11.0")
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

plugins {
	id("org.springframework.boot") version "2.4.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.32"
	kotlin("plugin.spring") version "1.4.32"
	id("com.netflix.dgs.codegen") version "4.4.1"
	jacoco
}

jacoco {
	toolVersion = "0.8.6"
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
