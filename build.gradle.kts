import org.gradle.api.tasks.testing.logging.TestExceptionFormat

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", version = "1.5.0"))
    }
}

subprojects {
    group = "com.inkapplications.subatomic"
    version = if (version != "unspecified") version else "1.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
    tasks.withType(Test::class) {
        testLogging.exceptionFormat = TestExceptionFormat.FULL
    }
}

tasks.create("zipPublications", Zip::class) {
    from("core/build/repo/")
    archiveFileName.set("publications.zip")
}
