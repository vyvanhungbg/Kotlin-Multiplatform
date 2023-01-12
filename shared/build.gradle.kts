plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization") version "1.7.21"
    id("kotlin-parcelize")
    id("kotlin-kapt")
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    val ktorVersion = "2.0.2"
    val version = "3.1.2"
    val dateTimeVersion = "0.4.0"

    val koin_core_version = "3.2.0"
    val okhttp_version = "4.7.2"
    val sqlDelightVersion = "1.5.3"
    val coroutinesVersion = "1.6.2"


    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

                implementation("io.ktor:ktor-client-json:${ktorVersion}")
                implementation("io.ktor:ktor-client-logging:${ktorVersion}")
                //implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
                implementation("io.ktor:ktor-client-cio:$ktorVersion")

                //implementation("io.ktor:ktor-client-logging-native:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")

                implementation( "io.insert-koin:koin-core:${koin_core_version}")

                //implementation("io.insert-koin:koin-test:${koin_core_version}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")

//                implementation("com.squareup.okhttp3:okhttp:${okhttp_version}")
//                implementation("com.squareup.okhttp3:logging-interceptor:${okhttp_version}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting{
            dependencies {
                implementation("io.ktor:ktor-client-android:$ktorVersion")
                implementation("io.insert-koin:koin-androidx-compose:$version")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies{
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    namespace = "com.suspend.android.networking_datastorage_demo"
    compileSdk = 32
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}