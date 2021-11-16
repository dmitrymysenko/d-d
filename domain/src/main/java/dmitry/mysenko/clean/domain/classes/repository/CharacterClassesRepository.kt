package dmitry.mysenko.clean.domain.classes.repository

import dmitry.mysenko.clean.domain.classes.models.CharacterClassFull
import dmitry.mysenko.clean.domain.classes.models.CharacterClassShort
import dmitry.mysenko.clean.domain.response.ResultWrapper

interface CharacterClassesRepository {

    suspend fun getCharacterClassesShort(): ResultWrapper<List<CharacterClassShort>>
    suspend fun getCharacterClassFull(index: String): ResultWrapper<CharacterClassFull>

}