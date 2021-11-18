package dmitry.mysenko.clean.domain.races.usecases

import dmitry.mysenko.clean.domain.races.models.CharacterRace
import dmitry.mysenko.clean.domain.races.repository.CharacterRacesRepository
import dmitry.mysenko.clean.domain.response.ResultWrapper
import javax.inject.Inject

class GetCharacterRaceUseCase @Inject constructor(private val characterRacesRepository: CharacterRacesRepository) {

    suspend fun execute(index: String): ResultWrapper<CharacterRace> {
        return characterRacesRepository.getCharacterRaceFull(index)
    }
}