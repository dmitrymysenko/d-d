package dmitry.mysenko.clean.data.classes.converter

import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassFull
import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassShort
import dmitry.mysenko.clean.domain.classes.models.CharacterClassFull
import dmitry.mysenko.clean.domain.classes.models.CharacterClassShort
import javax.inject.Inject

class CharacterClassesConverter @Inject constructor() {

    fun remoteCharacterClassShortToCharacterClassShort(remoteCharacterClassShort: RemoteCharacterClassShort) =
        CharacterClassShort(
            index = remoteCharacterClassShort.index,
            name = remoteCharacterClassShort.name,
            url = remoteCharacterClassShort.url
        )

    fun remoteCharacterClassFullToCharacterClassFull(remoteCharacterClassFull: RemoteCharacterClassFull) =
        CharacterClassFull(
            index = remoteCharacterClassFull.index,
            name = remoteCharacterClassFull.name,
            hitDie = remoteCharacterClassFull.hitDie,
        )
}