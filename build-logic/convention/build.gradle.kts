import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.kotdev.trading.buildlogic"

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "kotdev.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidApplication") {
            id = "kotdev.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "kotdev.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("coreUi") {
            id = "kotdev.core.ui"
            implementationClass = "CoreUiConventionPlugin"
        }
        register("androidLibrary") {
            id = "kotdev.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidTest") {
            id = "kotdev.android.test"
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("navigation") {
            id = "kotdev.navigation"
            implementationClass = "AndroidNavConventionPlugin"
        }
        register("androidHilt") {
            id = "kotdev.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidRoom") {
            id = "kotdev.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("jvmLibrary") {
            id = "volution.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }

    }
}