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
include(":articles:compose")
include(":articles:presentation")
include(":history:compose")
include(":history:model")
include(":history:data")
include(":history:presentation")
include(":splash:compose")
include(":splash:presentation")
include(":trading:compose")
include(":trading:data")
include(":trading:model")
include(":trading:presentation")

gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))