package dmitry.mysenko.clean.data.races.datasource.remote

import dmitry.mysenko.clean.data.races.datasource.remote.models.RemoteCharacterRaceFull
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterRacesService {
    @GET("races/{index}")
    suspend fun getCharacterRaceFull(@Path("index") index: String): RemoteCharacterRaceFull
}