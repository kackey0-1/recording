import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "3.2.5"
  id("io.spring.dependency-management") version "1.1.4"
  id("org.jetbrains.kotlin.plugin.noarg") version "1.9.23"
  kotlin("jvm") version "1.9.23"
  kotlin("plugin.spring") version "1.9.23"
}

group = "com.hypo.driven"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
  mavenCentral()
}

noArg {
  annotation("com.hypo.driven.NoArg")
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.springframework.boot:spring-boot-starter-web")
  // implementation("org.springframework.boot:spring-boot-devtools")
  // implementation("org.springframework.boot:spring-boot-actuator")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

  // social login
  implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
  // implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

  // datasource
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.mysql:mysql-connector-j:8.2.0")

  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs += "-Xjsr305=strict"
    jvmTarget = "21"
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
