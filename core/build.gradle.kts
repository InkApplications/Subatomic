  
plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

kotlin {
    jvm()
    js {
        nodejs()
        browser()
    }
    linuxArm64()
    linuxArm32Hfp()
    linuxMips32()
    linuxX64()
    mingwX64()
    macosX64()

    sourceSets {
        val commonMain by getting
        val nativeMain by creating {
            dependsOn(commonMain)
        }

        val linuxArm64Main by getting {
            dependsOn(nativeMain)
        }
        val linuxArm32HfpMain by getting {
            dependsOn(nativeMain)
        }
        val linuxMips32Main by getting {
            dependsOn(nativeMain)
        }
        val linuxX64Main by getting {
            dependsOn(nativeMain)
        }
        val mingwX64Main by getting {
            dependsOn(nativeMain)
        }
        val macosX64Main by getting {
            dependsOn(nativeMain)
        }
    }
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
}

publishing {
    group = "com.inkapplications.subatomic"
    version = when (project.properties["version"]?.toString()) {
        null, "unspecified", "" -> "1.1-SNAPSHOT"
        else -> project.properties["version"].toString()
    }
    publications {
        withType<MavenPublication> {
            artifact(javadocJar.get())

            pom {
                name.set("Subatomic: ${project.name}")
                description.set("Simple Multiplatform atomic references.")
                url.set("https://github.com/inkapplications/subatomic")
                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://choosealicense.com/licenses/mit/")
                    }
                }
                developers {
                    developer {
                        id.set("reneevandervelde")
                        name.set("Renee Vandervelde")
                        email.set("Renee@InkApplications.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/InkApplications/subatomic.git")
                    developerConnection.set("scm:git:ssh://git@github.com:InkApplications/subatomic.git")
                    url.set("https://github.com/InkApplications/subatomic")
                }
            }
        }
    }

    repositories {
        maven {
            name = "Build"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}
