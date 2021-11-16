package dmitry.mysenko.clean.domain.classes.usecases

import dmitry.mysenko.clean.domain.classes.models.CharacterClassShort
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class GetClassesShortUseCase @Inject constructor(private val characterClassesRepository: CharacterClassesRepository) {

    suspend fun execute(): ResultWrapper<List<CharacterClassShort>>{
        return characterClassesRepository.getCharacterClassesShort()
    }
}