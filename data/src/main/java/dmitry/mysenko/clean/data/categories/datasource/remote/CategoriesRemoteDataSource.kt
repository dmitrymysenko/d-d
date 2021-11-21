package dmitry.mysenko.clean.data.categories.datasource.remote

import dmitry.mysenko.clean.data.base.BaseRemoteDataSource
import dmitry.mysenko.clean.data.categories.datasource.remote.models.RemoteCategoriesResponse
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CategoriesRemoteDataSource @Inject constructor(private val apiService: CategoriesService) :
    BaseRemoteDataSource() {

    suspend fun getAllCharacterClassesShort(category: String, name: String): ResultWrapper<RemoteCategoriesResponse> =
        safeApiCall { apiService.getAllCategoriesShort(category = category, name = name) }
}