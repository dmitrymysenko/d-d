package dmitry.mysenko.clean.domain.classes.repository

import dmitry.mysenko.clean.domain.classes.models.CharacterClass
import dmitry.mysenko.clean.domain.response.ResultWrapper

interface CharacterClassesRepository {

    suspend fun getCharacterClassFull(index: String): ResultWrapper<CharacterClass>

}