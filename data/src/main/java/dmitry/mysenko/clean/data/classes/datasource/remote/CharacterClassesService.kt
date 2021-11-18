package dmitry.mysenko.clean.data.classes.datasource.remote

import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassFull
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterClassesService {
    @GET("classes/{index}")
    suspend fun getCharacterClassFull(@Path("index") index: String): RemoteCharacterClassFull
}