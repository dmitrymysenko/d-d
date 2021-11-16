package dmitry.mysenko.clean.data.classes.datasource.remote

import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassFull
import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassesShortResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterClassesService {

    @GET("classes")
    suspend fun getAllCharacterClassesShort(): RemoteCharacterClassesShortResponse

    @GET("classes/{index}")
    suspend fun getCharacterClassFull(@Path("index") index: String): RemoteCharacterClassFull
}