plugins {
  id("org.springframework.boot") version "2.3.3.RELEASE"
  id("io.spring.dependency-management") version "1.0.10.RELEASE"
  kotlin("jvm")
  kotlin("plugin.spring") version "1.3.72"
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.jetbrains.kotlin:kotlin-allopen")
  implementation("com.fasterxml.jackson.core:jackson-annotations")
  implementation("com.fasterxml.jackson.core:jackson-core")
  implementation("com.fasterxml.jackson.core:jackson-databind")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
  implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
  runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
  runtimeOnly("org.postgresql:postgresql")

  implementation(project(":user-management"))
  implementation(project(":utils"))

  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}