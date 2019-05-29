plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Config.Libs.kotlin_stdlib)
    implementation(Config.Libs.appCompat)
    implementation(Config.Libs.coreKtx)
    implementation(Config.Libs.constraintLayout)

    testImplementation(Config.TestLibs.junit)
    androidTestImplementation(Config.TestLibs.runner)
    androidTestImplementation(Config.TestLibs.espressoCore)
}
