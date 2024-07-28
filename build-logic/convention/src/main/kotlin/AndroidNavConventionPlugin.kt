import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class AndroidNavConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("kotdev.android.library")
            }
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")
            dependencies {
                "api"(libs.findLibrary("android-navigation").get())
                "api"(libs.findLibrary("android-navigation-screenmodel").get())
                "api"(libs.findLibrary("android-navigation-kodein").get())
            }
        }
    }

}