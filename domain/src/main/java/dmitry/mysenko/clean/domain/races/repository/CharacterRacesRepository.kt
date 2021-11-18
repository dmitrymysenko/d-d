package dmitry.mysenko.clean.domain.races.repository

import dmitry.mysenko.clean.domain.races.models.CharacterRace
import dmitry.mysenko.clean.domain.response.ResultWrapper

interface CharacterRacesRepository {

    suspend fun getCharacterRaceFull(index: String): ResultWrapper<CharacterRace>

}