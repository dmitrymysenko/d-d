package dmitry.mysenko.clean.data.classes.datasource.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacterClassesShortResponse(
    val count: Int,
    val results: List<RemoteCharacterClassShort>
)
