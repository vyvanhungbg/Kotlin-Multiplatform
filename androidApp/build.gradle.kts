plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.suspend.android.networking_datastorage_demo.android"
    compileSdk = 32
    defaultConfig {
        applicationId = "com.suspend.android.networking_datastorage_demo.android"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }

    }

}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.2.1")
    implementation("androidx.compose.ui:ui-tooling:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    implementation("androidx.compose.foundation:foundation:1.2.1")
    implementation("androidx.compose.material:material:1.2.1")
    implementation("androidx.activity:activity-compose:1.5.1")

    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.2")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")

     val koin_version = "3.2.0"
     val koin_core_version = "3.2.0"

    implementation( "io.insert-koin:koin-core:${koin_core_version}")
    implementation( "io.insert-koin:koin-android:${koin_version}")
    /*implementation("io.insert-koin:koin-androidx-navigation:${koin_version}")
    implementation("io.insert-koin:koin-androidx-compose:${koin_version}")*/
}