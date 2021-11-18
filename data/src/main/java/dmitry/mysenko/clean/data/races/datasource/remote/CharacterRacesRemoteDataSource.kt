package dmitry.mysenko.clean.data.races.datasource.remote

import dmitry.mysenko.clean.data.base.BaseRemoteDataSource
import dmitry.mysenko.clean.data.classes.datasource.remote.CharacterClassesService
import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassFull
import dmitry.mysenko.clean.data.races.datasource.remote.models.RemoteCharacterRaceFull
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CharacterRacesRemoteDataSource @Inject constructor(private val apiService: CharacterRacesService) :
    BaseRemoteDataSource() {

    suspend fun getCharacterRaceFull(index: String): ResultWrapper<RemoteCharacterRaceFull> =
        safeApiCall { apiService.getCharacterRaceFull(index) }
}