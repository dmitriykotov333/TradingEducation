plugins {
    id("kotdev.android.application")
    id("kotdev.android.application.compose")
    id("kotlin-kapt")
    alias(libs.plugins.dagger.hilt)
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.jetbrains.kotlin.android)
//    alias(libs.plugins.compose.compiler)
//    alias(libs.plugins.dagger.hilt)
    kotlin("plugin.serialization") version "2.0.0"
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.kotdev.trading"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kotdev.trading"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField("String", "API_KEY", "${project.findProperty("API_KEY")}")
        buildConfigField("String", "PROJECT_ID", "${project.findProperty("PROJECT_ID")}")
        buildConfigField("String", "COLLECTION_ID", "${project.findProperty("COLLECTION_ID")}")
        buildConfigField("String", "DATABASE_ID", "${project.findProperty("DATABASE_ID")}")
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
//    composeOptions {
//        kotlinCompilerExtensionVersion = "1.5.14"
//    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}
composeCompiler {
    enableStrongSkippingMode = true

    reportsDestination = layout.buildDirectory.dir("compose_compiler")
}
dependencies {
    implementation(project(":core"))
   implementation(project(":core_ui"))
    implementation(project(":navigation"))
    implementation(project(":trading:data"))
 //   implementation(project(":service"))
    implementation(libs.android.hilt)
    kapt(libs.android.hilt.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    implementation(libs.android.navigation)
    implementation(libs.android.navigation.ui)
    implementation(libs.android.coroutine)
    implementation(libs.android.collections.immutable)
    implementation(libs.android.lifecycle.viewmodel)
    implementation(libs.android.viewmodel.savedstate)
    implementation(libs.android.lifecycle.runtime)
    kapt(libs.android.lifecycle.compiler)
    implementation(libs.android.coil.compose)
    implementation(libs.android.chart)
    implementation(libs.serialization.json)
    implementation(libs.android.room.paging)
    implementation(libs.android.paging.runtime)
    implementation(libs.android.paging.compose)
    implementation(libs.android.ktor.core)
    implementation(libs.android.ktor.json)
    implementation(libs.android.ktor.serialization)
    implementation(libs.android.ktor.serialization.json)
    implementation(libs.android.ktor.client)
    implementation(libs.android.ktor.negotiation)
    implementation(libs.android.ktor.logging)
    implementation(libs.android.appwrite)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}