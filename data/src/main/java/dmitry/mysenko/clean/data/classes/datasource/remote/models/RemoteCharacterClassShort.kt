package dmitry.mysenko.clean.data.classes.datasource.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacterClassShort(
    val index: String,
    val name: String,
    val url: String
)
