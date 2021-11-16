package dmitry.mysenko.clean.data.classes.repository

import dmitry.mysenko.clean.data.classes.converter.CharacterClassesConverter
import dmitry.mysenko.clean.data.classes.datasource.remote.CharacterClassesRemoteDataSource
import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassesShortResponse
import dmitry.mysenko.clean.domain.classes.models.CharacterClassFull
import dmitry.mysenko.clean.domain.classes.models.CharacterClassShort

import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CharacterClassesRepositoryImpl @Inject constructor(
    private val characterClassesRemoteDataSource: CharacterClassesRemoteDataSource,
    private val converter: CharacterClassesConverter
) : CharacterClassesRepository {

    override suspend fun getCharacterClassesShort(): ResultWrapper<List<CharacterClassShort>> {
        return when (val response =
            characterClassesRemoteDataSource.getAllCharacterClassesShort()) {
            is ResultWrapper.Success -> ResultWrapper.Success(response.value.results.map { remote ->
                converter.remoteCharacterClassShortToCharacterClassShort(
                    remote
                )
            })
            is ResultWrapper.GenericError -> response
        }
    }

    override suspend fun getCharacterClassFull(index: String): ResultWrapper<CharacterClassFull> {
        return when (val response =
            characterClassesRemoteDataSource.getCharacterClassFull(index)) {
            is ResultWrapper.Success -> ResultWrapper.Success(
                converter.remoteCharacterClassFullToCharacterClassFull(
                    response.value
                )
            )
            is ResultWrapper.GenericError -> response
        }
    }
}