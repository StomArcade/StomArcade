plugins {
    id("groovy")
}

group = "net.bitbylogic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.groovy:groovy:5.0.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Minestom
    implementation("net.minestom:minestom:2025.12.20-1.21.11")
}

tasks.test {
    useJUnitPlatform()
}