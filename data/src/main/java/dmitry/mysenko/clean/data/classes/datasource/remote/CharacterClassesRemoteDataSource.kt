package dmitry.mysenko.clean.data.classes.datasource.remote

import dmitry.mysenko.clean.data.base.BaseRemoteDataSource
import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassFull
import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassesShortResponse
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CharacterClassesRemoteDataSource @Inject constructor(private val apiService: CharacterClassesService) :
    BaseRemoteDataSource() {

    suspend fun getAllCharacterClassesShort(): ResultWrapper<RemoteCharacterClassesShortResponse> =
        safeApiCall { apiService.getAllCharacterClassesShort() }


    suspend fun getCharacterClassFull(index: String): ResultWrapper<RemoteCharacterClassFull> =
        safeApiCall { apiService.getCharacterClassFull(index) }


}