package dmitry.mysenko.clean.domain.classes.usecases

import dmitry.mysenko.clean.domain.classes.models.CharacterClass
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class GetCharacterClassUseCase @Inject constructor(private val characterClassesRepository: CharacterClassesRepository) {

    suspend fun execute(index: String): ResultWrapper<CharacterClass>{
        return characterClassesRepository.getCharacterClassFull(index)
    }
}