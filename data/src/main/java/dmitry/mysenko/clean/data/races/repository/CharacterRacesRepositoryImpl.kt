package dmitry.mysenko.clean.data.races.repository

import dmitry.mysenko.clean.data.races.converter.CharacterRacesConverter
import dmitry.mysenko.clean.data.races.datasource.remote.CharacterRacesRemoteDataSource
import dmitry.mysenko.clean.domain.races.models.CharacterRace
import dmitry.mysenko.clean.domain.races.repository.CharacterRacesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class CharacterRacesRepositoryImpl @Inject constructor(
    private val characterRacesRemoteDataSource: CharacterRacesRemoteDataSource,
    private val converter: CharacterRacesConverter
): CharacterRacesRepository {

    override suspend fun getCharacterRaceFull(index: String): ResultWrapper<CharacterRace> {
        return when (val response =
            characterRacesRemoteDataSource.getCharacterRaceFull(index)) {
            is ResultWrapper.Success -> ResultWrapper.Success(
                converter.remoteCharacterRaceFullToCharacterRace(
                    response.value
                )
            )
            is ResultWrapper.GenericError -> response
        }
    }
}