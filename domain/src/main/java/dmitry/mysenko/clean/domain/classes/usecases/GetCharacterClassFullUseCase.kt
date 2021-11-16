package dmitry.mysenko.clean.domain.classes.usecases

import dmitry.mysenko.clean.domain.classes.models.CharacterClassFull
import dmitry.mysenko.clean.domain.classes.repository.CharacterClassesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class GetCharacterClassFullUseCase @Inject constructor(private val characterClassesRepository: CharacterClassesRepository) {

    suspend fun execute(index: String): ResultWrapper<CharacterClassFull>{
        return characterClassesRepository.getCharacterClassFull(index)
    }
}