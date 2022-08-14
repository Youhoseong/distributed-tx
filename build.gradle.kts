import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.2"
	id("io.spring.dependency-management") version "1.0.12.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21" apply false
}

java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
	group = "winter.company"
	version = "0.0.1-SNAPSHOT"

	repositories {
		mavenCentral()
	}
}

subprojects {
	apply(plugin = "java")
	apply(plugin = "io.spring.dependency-management")
	apply(plugin = "org.springframework.boot")

	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}

	dependencies {
		implementation("org.springframwork.kafka:spring-kafka")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		compileOnly("org.projectlombok:lombok")
		developmentOnly("org.springframework.boot:spring-boot-devtools")
		annotationProcessor("org.projectlombok:lombok")
		testImplementation("org.springframework.boot:spring-boot-starter-test")

	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}
}

project(":payment") {
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-webflux")
		testImplementation("io.projectreactor:reactor-test")
	}
}

project(":card") {
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-webflux")
		testImplementation("io.projectreactor:reactor-test")
	}
}
