plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.example.menu"
}

dependencies{
    implementation(projects.core.domain)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)
}