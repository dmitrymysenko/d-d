package dmitry.mysenko.clean.data.categories.datasource.remote

import dmitry.mysenko.clean.data.categories.datasource.remote.models.RemoteCategoriesResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoriesService {

    @GET("{category}")
    suspend fun getAllCategoriesShort(@Path("category") category: String, @Query("name") name: String): RemoteCategoriesResponse
}