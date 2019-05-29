object Config {

    /**
     * Application configuration
     */

    object Android {
        private const val versionMajor = 1
        private const val versionMinor = 0
        private const val versionPatch = 0
        private const val versionBuild = 0
        const val versionCode = versionMajor * 1000000 + versionMinor * 10000 + versionPatch * 100 + versionBuild
        const val versionName = "$versionMajor.$versionMinor.$versionPatch"

        const val applicationId = "io.smallant.gamebook"

        const val minSdkVersion = 16
        const val targetSdkVersion = 28
        const val compileSdkVersion = 28
    }

    /**
     * Versions & Dependencies
     */

    private const val kotlinVersion = "1.3.31"
    private const val kotlinCoroutinesVersion = "1.2.1"
    private const val lifecycleExtensionsVersion = "2.0.0"
    private const val appCompatVersion = "1.0.2"
    private const val coreKtxVersion = "1.0.2"
    private const val constraintLayoutVersion = "1.1.3"
    private const val androidGradleVersion = "3.4.1"
    private const val roomVersion = "2.1.0-beta01"

    private const val junitVersion = "4.12"
    private const val runnerVersion = "1.1.1"
    private const val espressoVersion = "3.1.1"

    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:$androidGradleVersion"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    }

    object Libs {
        // Kotlin + Coroutines
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinCoroutinesVersion"

        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"
        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleExtensionsVersion"

        // Room
        const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
        const val roomCompiler = "androidx.room:room-compiler:$roomVersion"
        const val roomKtx = "androidx.room:room-ktx:$roomVersion"
    }

    object TestLibs {
        const val junit = "junit:junit:$junitVersion"
        const val runner = "androidx.test:runner:$runnerVersion"
        const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"
    }
}