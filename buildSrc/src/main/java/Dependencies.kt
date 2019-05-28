
object Config {
    private const val versionMajor = 1
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionBuild = 0
    const val versionCode = versionMajor * 1000000 + versionMinor * 10000 + versionPatch * 100 + versionBuild
    const val versionName = "$versionMajor.$versionMinor.$versionPatch"

    const val minSdk = 16
    const val targetSdk = 28
    const val compileSdk = 28
}

object Versions {
    const val kotlin = "1.3.31"
    const val lifecycleExtensions = "2.0.0"
    const val appCompat = "1.0.2"
    const val coreKtx = "1.0.2"
    const val constraintLayout = "1.1.3"
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
}