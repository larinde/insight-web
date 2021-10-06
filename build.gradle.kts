import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {

	//id("org.springframework.boot") version "2.5.2"
	//id("io.spring.dependency-management") version "1.0.11.RELEASE"
	//kotlin("jvm") version "1.5.20"
	//kotlin("plugin.spring") version "1.5.20"

	//id("org.springframework.boot") version "2.4.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.4.32"
	kotlin("plugin.spring") version "1.4.32"
	id("com.netflix.dgs.codegen") version "4.4.1"
	id("com.microsoft.azure.azurefunctions") version "1.5.0"
	jacoco
}

group = "com.koweg.insight"



version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8
repositories {
	mavenCentral()
	mavenLocal()
}
extra["azureFunctionsVersion"] = "1.4.2"
extra["springCloudFunctionVersion"] = "3.1.3"
extra["springCloudVersion"] = "2020.0.3"
extra["arrowVersion"] = "0.13.2"
extra["testcontainersVersion"] = "1.15.3"
extra["dgsPlatformVersion"] = "4.3.1"


/*
dependencies {
	testImplementation("org.springframework.boot:spring-boot-starter-test"){
		exclude("junit", "junit")
	}
}
*/

dependencies {
	//implementation ("commons-io:commons-io:2.10.0")
	implementation ("com.microsoft.azure.functions:azure-functions-java-library")

	implementation("org.springframework.cloud:spring-cloud-function-adapter-azure"){
		exclude("com.fasterxml.jackson.core")
	}
	implementation("org.springframework.cloud:spring-cloud-function-kotlin")
	implementation("org.springframework.cloud:spring-cloud-starter-function-web")
	implementation("org.springframework.cloud:spring-cloud-starter-function-webflux")

//	implementation("org.springframework.boot:spring-boot-starter-web"){
//		exclude("com.fasterxml.jackson.core")
//	}
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.5")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("com.yahoofinance-api:YahooFinanceAPI:3.15.0"){
		exclude("com.fasterxml.jackson.core")
	}


	implementation(
		platform("com.netflix.graphql.dgs:graphql-dgs-platform-dependencies:${property("dgsPlatformVersion")}")
	)
	implementation("com.netflix.graphql.dgs:graphql-dgs-spring-boot-starter")
	implementation("com.netflix.graphql.dgs:graphql-dgs-extended-scalars")
	implementation("com.netflix.graphql.dgs:graphql-dgs-subscriptions-websockets-autoconfigure")


	// Azure APM agent
	implementation("com.microsoft.azure:applicationinsights-web-auto:2.6.3")
	implementation("com.microsoft.azure:applicationinsights-core:2.6.3")
	implementation("com.microsoft.azure:applicationinsights-logging-logback:2.6.3")
	implementation("com.microsoft.azure:applicationinsights-spring-boot-starter:2.6.3")


	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("com.jayway.jsonpath:json-path:2.2.0")
	testImplementation("io.mockk:mockk:1.11.0")
	testImplementation("org.assertj:assertj-core:3.19.0")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-function-dependencies:${property("springCloudFunctionVersion")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		mavenBom("com.microsoft.azure.functions:azure-functions-java-library:${property("azureFunctionsVersion")}")
		//mavenBom("org.testcontainers:testcontainers-bom:${property("testcontainersVersion")}")
	}
}


azurefunctions {
	subscription = "f2b3ce42-63af-41f3-932b-e1b2bf83ad6f"
	resourceGroup = "kowegAzFctnGrp"
	appName = "azureFctnSpring"
	pricingTier = "Consumption"
	region = "westus"
	runtime to ("os" to "linux")
	appSettings to ("fdaEventsPublicationEndpoint" to "https://api.fda.gov/drug/drugsfda.json")
	authentication to ("type" to "azure_cli")
	allowTelemetry = false
}

tasks.jacocoTestReport {
	reports {
		xml.required.set(false)
		csv.required.set(true)
		html.outputLocation.set(layout.buildDirectory.dir("reports/jacoco/test/html"))
	}
}

tasks.test {
	finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
}

tasks.jacocoTestCoverageVerification {
	violationRules {
		rule {
			limit {
				minimum = "0.5".toBigDecimal()
			}
		}

		rule {
			enabled = false
			element = "CLASS"
			includes = listOf("org.gradle.*")

			limit {
				counter = "LINE"
				value = "TOTALCOUNT"
				maximum = "0.3".toBigDecimal()
			}
		}
	}
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
	packageName = "uk.co.koweg.insight.domain.api.generated"
}
