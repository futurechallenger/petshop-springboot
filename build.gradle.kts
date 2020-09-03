import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  base
  kotlin("jvm") version "1.3.72"
}

allprojects{
  group = "com.petshop"
  version = "0.0.1-SNAPSHOT"
//  java.sourceCompatibility = JavaVersion.VERSION_1_8

  repositories {
    mavenCentral()
  }
}

subprojects {
  tasks.withType<KotlinCompile>().configureEach {
    println("Configuring $name in project ${project.name}...")
    kotlinOptions {
      jvmTarget = "1.8"
      suppressWarnings = true
    }
  }
}

extra["springCloudVersion"] = "Hoxton.SR7"

//dependencies {
//  subprojects.forEach { archives(it) }
//}

//dependencyManagement {
//  imports {
//    mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//  }
//}

tasks.withType<Test> {
  exclude("**/*")
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
