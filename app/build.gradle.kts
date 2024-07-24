plugins {
    id("kotdev.android.application")
    id("kotdev.android.application.compose")
    id("kotdev.android.hilt")
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
        compose = true
    }
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.android.coil.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}