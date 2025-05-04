plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.serialization") version "1.8.0"
    id("org.jetbrains.dokka") version "1.8.10"
}

group = "es.prog2425.u4u5u6libre"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("com.github.ajalt.mordant:mordant:2.0.0")
    implementation("org.fusesource.jansi:jansi:2.4.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

tasks.dokkaHtml {
    outputDirectory.set(file("docs")) // Aquí se generará la documentación
}