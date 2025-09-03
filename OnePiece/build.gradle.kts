plugins {
    kotlin("jvm") version "2.0.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //base de datos en h2
    implementation("com.h2database:h2:2.3.232")

    //JDBI
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jdbi:jdbi3-core:3.48.0")
    implementation("org.jdbi:jdbi3-sqlobject:3.48.0")
    implementation("org.jdbi:jdbi3-kotlin:3.48.0")
    implementation("org.jdbi:jdbi3-kotlin-sqlobject:3.48.0")

    //logger
    implementation("org.lighthousegames:logging:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.5.12")

   //Result:ROP
    implementation("com.michael-bull.kotlin-result:kotlin-result:2.0.1")

    //cache caffeine
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.0")

    //Serializacion Json
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.8.0")

    //Serializacion Xml
    implementation("io.github.pdvrieze.xmlutil:serialization-jvm:0.90.3")

    //test
    testImplementation("io.mockk:mockk:1.13.16")
    testImplementation(kotlin("test"))
    testImplementation("org.jdbi:jdbi3-testing:3.48.0")

    //

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}