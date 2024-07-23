plugins {
    id("kotdev.navigation")
}
android {
    namespace = "com.kotdev.trading.navigation"
}

dependencies {
    implementation(project(":core"))
    implementation(project(":splash:compose"))
    implementation(project(":history:compose"))
    implementation(project(":articles:compose"))
    implementation(project(":trading:compose"))
}