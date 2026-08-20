import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply(ConventionConstants.Plugins.ANDROID_LIBRARY)
            pluginManager.apply(ConventionConstants.Plugins.KSP)

            extensions.configure<LibraryExtension> {
                configureAndroidLibrary(this)
            }

            configureCompose()
            configureStorageDependencies()
        }
    }
}