object Config {
    const val compileSdk = 31
    const val minSDK = 24
    const val targetSDK = 31

    const val versionCode = 1
    const val versionMajor = 0
    const val versionMinor = 0
    const val versionPatch = 1

    const val packageName = "dmitry.mysenko.clean"

    const val minifyEnabled  = false

    fun version() = "$versionMajor.$versionMinor.$versionPatch"
}