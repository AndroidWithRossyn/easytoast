import java.util.Properties
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    id("signing")
}

android {
    namespace = "com.rossyn.esaytoast.kts"
    compileSdk = 35

    defaultConfig {
        minSdk = 21

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
}

fun getLocalProperty(key: String, defaultValue: String = ""): String {
    val properties = Properties()
    val localProperties = File(rootProject.projectDir, "local.properties")
    if (localProperties.isFile) {
        InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    }
    return properties.getProperty(key, defaultValue)
}

val libVersionName = "1.0.0"
val libGroupId = "com.rossyn.esaytoast.kts"
val libArtifactId = "esaytoast"

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = libGroupId
            artifactId = libArtifactId
            version = libVersionName

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set(libArtifactId)
                description.set("Easily manage Toast context and length in your Kotlin Android apps with this lightweight library")
                url.set("https://github.com/AndroidWithRossyn/easytoast")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("AndroidWithRossyn")
                        name.set("Rossyn")
                        email.set("banrossyn@gmail.com")
                    }
                    developer {
                        id.set("rohitraj-khorwal")
                        name.set("Rohitraj Khorwal")
                        email.set("rohitrajkhorwal.dev@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:github.com/AndroidWithRossyn/easytoast.git")
                    developerConnection.set("scm:git:ssh://github.com/AndroidWithRossyn/easytoast.git")
                    url.set("https://github.com/AndroidWithRossyn/easytoast/tree/main")
                }
            }
        }
    }

    repositories {
        maven {
            name = "sonatype"
            url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
            credentials {
                username = getLocalProperty("OSSRH_USERNAME")
                password = getLocalProperty("OSSRH_PASSWORD")
            }
        }
    }
}

signing {
    val signingKeyId = System.getenv("SIGNING_KEY_ID") ?: getLocalProperty("signing.keyId")
    val signingKey = System.getenv("SIGNING_KEY") ?: getLocalProperty("signing.secretKeyRingFile")
    val signingPassword = System.getenv("SIGNING_PASSWORD") ?: getLocalProperty("signing.password")

    if (signingKeyId.isNotEmpty()) {
        useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
        sign(publishing.publications["release"])
    } else {
        logger.warn("Signing credentials are missing. Signing will be skipped.")
    }
}