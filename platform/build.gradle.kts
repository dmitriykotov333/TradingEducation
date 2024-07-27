plugins {
    id("kotdev.android.library")
    id("kotdev.android.kodein")
}

android {
    namespace = "com.kotdev.trading.platform"
}

dependencies {
    implementation(project(":database:core"))
    implementation(project(":appwrite"))
    implementation(project(":service"))
    implementation(project(":articles:presentation"))
    implementation(project(":history:data"))
    implementation(project(":trading:data"))
}

