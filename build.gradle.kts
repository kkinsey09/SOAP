import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.5.10"
    `java-library`
    application
}

group = "us.cpwa.firedept"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClass.set("us.cpwa.firedept.MainKt")
}

tasks.register("fatJar", type = Jar::class) {
    archiveBaseName.set(project.name)
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    with(tasks.jar.get() as CopySpec)
    manifest {
        attributes["Implementation-Title"] = project.name
        attributes["Implementation-Version"] = archiveVersion
        attributes["Main-Class"] = "us.cpwa.firedept.MainKt"
    }
}

tasks.build { dependsOn(tasks["fatJar"]) }

tasks.compileJava {
    options.release.set(8)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
