package dmitry.mysenko.clean.data.races.converter

import dmitry.mysenko.clean.data.races.datasource.remote.models.RemoteCharacterRaceFull
import dmitry.mysenko.clean.domain.races.models.CharacterRace
import javax.inject.Inject

class CharacterRacesConverter @Inject constructor() {

    fun remoteCharacterRaceFullToCharacterRace(remoteCharacterRaceFull: RemoteCharacterRaceFull) =
        CharacterRace(
            index = remoteCharacterRaceFull.index,
            name = remoteCharacterRaceFull.name,
            speed = remoteCharacterRaceFull.speed,
        )
}