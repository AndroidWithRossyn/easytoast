plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
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
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        register<MavenPublication>("release") {
            afterEvaluate {
                from(components.findByName("release"))
            }
            groupId = "com.github.AndroidWithRossyn"
            artifactId = "esaytoast"
            version = "1.0.3"

            pom {
                name.set("EasyToast")
                description.set("A simple utility library for displaying custom toasts in Android.")
                url.set("https://github.com/AndroidWithRossyn/esaytoast")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("AndroidWithRossyn")
                        name.set("AndroidWithRossyn")
                        email.set("rohitrajkhorwal.dev@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:github.com/AndroidWithRossyn/esaytoast.git")
                    developerConnection.set("scm:git:ssh://github.com/AndroidWithRossyn/esaytoast.git")
                    url.set("https://github.com/AndroidWithRossyn/esaytoast")
                }
            }

        }
    }
}
