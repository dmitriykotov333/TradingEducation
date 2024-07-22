import java.net.URI


pluginManagement {
    includeBuild("build-logic")
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
        maven { url = URI("https://jitpack.io") }
    }
}

rootProject.name = "Trading Education"
include(":app")
include(":appwrite")
include(":core")
include(":core_ui")
include(":navigation")
include(":database:core")
include(":database:pair")
include(":database:balance")
include(":database:history")
include(":service")
include(":history:compose")
include(":history:data")
include(":history:presentation")
include(":splash:compose")
include(":splash:presentation")

gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))