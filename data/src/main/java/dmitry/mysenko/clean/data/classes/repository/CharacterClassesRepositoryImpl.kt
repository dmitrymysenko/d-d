package dmitry.mysenko.clean.data.classes.repository

import dmitry.mysenko.clean.data.classes.converter.CharacterClassesConverter
import dmitry.mysenko.clean.data.classes.datasource.remote.CharacterClassesRemoteDataSource
import dmitry.mysenko.clean.domain.classes.models.CharacterClass

import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CharacterClassesRepositoryImpl @Inject constructor(
    private val characterClassesRemoteDataSource: CharacterClassesRemoteDataSource,
    private val converter: CharacterClassesConverter
) : CharacterClassesRepository {

    override suspend fun getCharacterClassFull(index: String): ResultWrapper<CharacterClass> {
        return when (val response =
            characterClassesRemoteDataSource.getCharacterClassFull(index)) {
            is ResultWrapper.Success -> ResultWrapper.Success(
                converter.remoteCharacterClassFullToCharacterClass(
                    response.value
                )
            )
            is ResultWrapper.GenericError -> response
        }
    }
}