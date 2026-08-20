import ConventionConstants.Configurations
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.implementation(libs: VersionCatalog, name: String): Dependency? =
    add(
        Configurations.IMPLEMENTATION,
        libs.findLibrary(name).get()
    )

internal fun DependencyHandler.testImplementation(libs: VersionCatalog, name: String): Dependency? =
    add(
        Configurations.TEST_IMPLEMENTATION,
        libs.findLibrary(name).get()
    )

internal fun DependencyHandler.debugImplementation(libs: VersionCatalog, name: String)
: Dependency? =
    add(
        Configurations.DEBUG_IMPLEMENTATION,
    libs.findLibrary(name).get()
    )

internal fun DependencyHandler.ksp(libs: VersionCatalog, name: String): Dependency? =
    add(
        Configurations.KSP,
        libs.findLibrary(name).get()
    )

internal fun DependencyHandler.implementationBundle(libs: VersionCatalog, name: String)
: Dependency? =
    add(
        Configurations.IMPLEMENTATION,
        libs.findBundle(name).get()
    )

internal fun DependencyHandler.testImplementationBundle(libs: VersionCatalog, name: String)
: Dependency? =
    add(
        Configurations.TEST_IMPLEMENTATION,
        libs.findBundle(name).get()
    )

internal fun DependencyHandler.debugImplementationBundle(libs: VersionCatalog, name: String)
: Dependency? =
    add(
        Configurations.DEBUG_IMPLEMENTATION,
        libs.findBundle(name).get()
    )

internal fun DependencyHandler.implementationPlatform(libs: VersionCatalog, name: String)
: Dependency? =
    add(
        Configurations.IMPLEMENTATION,
        platform(libs.findLibrary(name).get())
    )