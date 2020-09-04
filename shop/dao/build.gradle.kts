import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot")
  id("io.spring.dependency-management")
  kotlin("jvm")
  kotlin("plugin.spring")
}

dependencies {
//  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  testImplementation("org.springframework.boot:spring-boot-starter-test") {
    exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
  kotlinOptions {
    freeCompilerArgs = listOf("-Xjsr305=strict")
    jvmTarget = "1.8"
  }
}
