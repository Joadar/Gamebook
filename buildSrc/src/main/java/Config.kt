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
    private const val lifecycleExtensionsVersion = "2.0.0"
    private const val appCompatVersion = "1.0.2"
    private const val coreKtxVersion = "1.0.2"
    private const val constraintLayoutVersion = "1.1.3"
    private const val androidGradleVersion = "3.4.1"

    object BuildPlugins {
        const val androidGradle = "com.android.tools.build:gradle:$androidGradleVersion"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    }

    object Libs {
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlinVersion"
        const val appCompat = "androidx.appcompat:appcompat:$appCompatVersion"
        const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutVersion"

        const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:$lifecycleExtensionsVersion"
    }

    object TestLibs {

    }
}