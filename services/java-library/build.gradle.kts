import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.JavaLibrary
import com.vanniktech.maven.publish.JavadocJar

plugins {
  `java-library`
  id("org.openapi.generator") version "7.15.0"
  id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "uk.nhs.tis.trainee"
version = "0.0.1"

dependencies {
  implementation("com.fasterxml.jackson.core:jackson-databind:2.18.2")
  implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.2")
  implementation("com.fasterxml.jackson.core:jackson-core:2.18.2")

  implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
  implementation("jakarta.validation:jakarta.validation-api:3.1.0")
//  runtimeOnly("org.hibernate.validator:hibernate-validator:8.0.1.Final")

}

openApiGenerate {
  generatorName.set("java")
  inputSpec.set(file("../../openapi/openapi.yml").toURI().toASCIIString())
  outputDir.set("$buildDir/generated")
  modelPackage.set("uk.nhs.trainee.contracts.dto")
  library.set("resttemplate")
  generateApiTests.set(false)
  generateModelTests.set(false)

  globalProperties.set(
    mapOf(
      "models" to "",
      "apis" to "false",
      "supportingFiles" to "false"
    )
  )

  configOptions.set(
    mapOf(
      "dateLibrary" to "java8",
      "useRecords" to "true",
      "useJakartaEe" to "true",
      "serializableModel" to "true",
      "serializationLibrary" to "jackson",
      "useBeanValidation" to "true",
      "useSpringBoot3" to "true"
    )
  )
}

mavenPublishing {
  configure(JavaLibrary(
    javadocJar = JavadocJar.Empty(),
    sourcesJar = true
  ))
//  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
//  signAllPublications()

  coordinates(artifactId = "contracts-dtos")

  pom {
    name = "TIS Trainee Contract DTOs"
    description = "Data transfer objects for TIS Trainee services."
    url = "https://github.com/Health-Education-England"

    developers {
      developer {
        name = "NHS England"
      }
    }

    licenses {
      license {
        name = "MIT"
        url = "https://opensource.org/license/mit"
      }
    }

    scm {
      url = "https://github.com/Health-Education-England/tis-trainee-contracts"
      connection.set("scm:git:git://github.com/Health-Education-England/tis-trainee-contracts.git")
      developerConnection.set("scm:git:ssh://git@github.com/Health-Education-England/tis-trainee-contracts.git")
    }
  }
}

sourceSets {
  named("main") {
    java.srcDir("$buildDir/generated/src/main/java")
  }
}

tasks.named<JavaCompile>("compileJava") {
  dependsOn(tasks.named("openApiGenerate"))
}

tasks.named<Jar>("sourcesJar") {
  dependsOn(tasks.named("openApiGenerate"))
}
