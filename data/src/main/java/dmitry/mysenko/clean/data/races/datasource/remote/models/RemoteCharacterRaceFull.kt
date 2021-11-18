package dmitry.mysenko.clean.data.races.datasource.remote.models

import dmitry.mysenko.clean.data.categories.datasource.remote.models.RemoteCategoryShort
import kotlinx.serialization.*

@Serializable
data class RemoteCharacterRaceFull (
    val index: String,
    val name: String,
    val speed: Long,

    @SerialName("ability_bonuses")
    val abilityBonuses: List<AbilityBonus>,

    val alignment: String,
    val age: String,
    val size: String,

    @SerialName("size_description")
    val sizeDescription: String,

//    @SerialName("starting_proficiencies")
//    val startingProficiencies: ???,

    val languages: List<RemoteCategoryShort>,

    @SerialName("language_desc")
    val languageDesc: String,

    val traits: List<RemoteCategoryShort>,
//    val subraces: ???,
    val url: String
)

@Serializable
data class AbilityBonus (
    @SerialName("ability_score")
    val abilityScore: RemoteCategoryShort,

    val bonus: Long
)
