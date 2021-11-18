package dmitry.mysenko.clean.data.categories.datasource.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class RemoteCategoryShort(
    val index: String,
    val name: String,
    val url: String
)
