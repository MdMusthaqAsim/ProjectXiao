plugins {
    id("java")
}

group = "org.genshin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.4.2")
    implementation ("mysql:mysql-connector-java:8.0.29")
}

tasks.test {
    useJUnitPlatform()
}