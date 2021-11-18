package dmitry.mysenko.clean.data.classes.converter

import dmitry.mysenko.clean.data.classes.datasource.remote.models.RemoteCharacterClassFull
import dmitry.mysenko.clean.data.categories.datasource.remote.models.RemoteCategoryShort
import dmitry.mysenko.clean.domain.classes.models.CharacterClass
import dmitry.mysenko.clean.domain.categories.models.CategoryItem
import javax.inject.Inject

class CharacterClassesConverter @Inject constructor() {

    fun remoteCharacterClassFullToCharacterClass(remoteCharacterClassFull: RemoteCharacterClassFull) =
        CharacterClass(
            index = remoteCharacterClassFull.index,
            name = remoteCharacterClassFull.name,
            hitDie = remoteCharacterClassFull.hitDie,
        )
}