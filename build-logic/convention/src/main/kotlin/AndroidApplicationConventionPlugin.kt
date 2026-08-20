import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ConventionConstants.Plugins.ANDROID_APPLICATION)
            pluginManager.apply(ConventionConstants.Plugins.KSP)

            extensions.configure<ApplicationExtension> {
                configureAndroidApplication(this)
            }

            configureCompose()
        }
    }
}