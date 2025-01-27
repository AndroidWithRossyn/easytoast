pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven { setUrl("https://plugins.gradle.org/m2") }
        maven { url = uri("https://jitpack.io") }
        mavenCentral { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Easy-Toast"
include(":esaytoast")
include(":app")
