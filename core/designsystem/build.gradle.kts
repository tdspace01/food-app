plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.example.designsystem"
}

dependencies{
    implementation(projects.core.domain)
}