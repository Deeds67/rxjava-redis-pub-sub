import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"
val flinkVersion = "1.18.1"
repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("redis.clients:jedis:5.0.0")
    implementation("io.lettuce:lettuce-core:6.3.2.RELEASE")
    implementation("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation("org.reactivestreams:reactive-streams:1.0.4")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}