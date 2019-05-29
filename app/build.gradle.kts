plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
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

    // Kotlin + Coroutines
    implementation(Config.Libs.kotlinStdlib)
    implementation(Config.Libs.kotlinCoroutines)

    implementation(Config.Libs.appCompat)
    implementation(Config.Libs.coreKtx)
    implementation(Config.Libs.constraintLayout)

    // Lifecyce
    implementation(Config.Libs.lifecycleExtensions)
    implementation(Config.Libs.lifecycleViewModelKtx)

    // Room
    implementation(Config.Libs.roomRuntime)
    kapt(Config.Libs.roomCompiler)
    implementation(Config.Libs.roomKtx)

    // Gson
    implementation(Config.Libs.gson)

    testImplementation(Config.TestLibs.junit)
    androidTestImplementation(Config.TestLibs.runner)
    androidTestImplementation(Config.TestLibs.espressoCore)
}
