package dmitry.mysenko.clean.data.categories.datasource.remote.models

import kotlinx.serialization.Serializable

@Serializable
data class RemoteCategoriesResponse(
    val count: Int,
    val results: List<RemoteCategoryShort>
)
