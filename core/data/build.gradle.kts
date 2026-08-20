plugins {
    alias(libs.plugins.convention.android.library)
}

android {
    namespace = "com.example.data"
}

dependencies{
    implementation(projects.core.domain)
}