package dmitry.mysenko.clean.data.classes.datasource.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCharacterClassFull(
    val index: String,
    val name: String,

    @SerialName("hit_die")
    val hitDie: Long,

    @SerialName("proficiency_choices")
    val proficiencyChoices: List<ProficiencyChoice>,

    val proficiencies: List<Proficiency>,

    @SerialName("saving_throws")
    val savingThrows: List<Proficiency>,

    @SerialName("starting_equipment")
    val startingEquipment: List<StartingEquipment>,

    @SerialName("starting_equipment_options")
    val startingEquipmentOptions: List<StartingEquipmentOption>,

    @SerialName("class_levels")
    val classLevels: String,

    @SerialName("multi_classing")
    val multiClassing: MultiClassing,

    val subclasses: List<Proficiency>,
    val spellcasting: Spellcasting,
    val spells: String,
    val url: String
)

@Serializable
data class MultiClassing (
    val prerequisites: List<Prerequisite>,
    val proficiencies: List<Proficiency>
)

@Serializable
data class Prerequisite (
    @SerialName("ability_score")
    val abilityScore: Proficiency,

    @SerialName("minimum_score")
    val minimumScore: Long
)

@Serializable
data class Proficiency (
    val index: String,
    val name: String,
    val url: String
)

@Serializable
data class ProficiencyChoice (
    val choose: Long,
    val type: String,
    val from: List<Proficiency>
)

@Serializable
data class Spellcasting (
    val level: Long,

    @SerialName("spellcasting_ability")
    val spellcastingAbility: Proficiency,

    val info: List<Info>
)

@Serializable
data class Info (
    val desc: List<String>,
    val name: String
)

@Serializable
data class StartingEquipment (
    val equipment: Proficiency,
    val quantity: Long
)

@Serializable
data class StartingEquipmentOption (
    val choose: Long,
    val type: String,
    val from: List<FromElement>
)

@Serializable
data class FromElement (
    val equipment: Proficiency? = null,
    val quantity: Long? = null,

    @SerialName("equipment_option")
    val equipmentOption: EquipmentOption? = null
)

@Serializable
data class EquipmentOption (
    val choose: Long,
    val type: String,
    val from: EquipmentOptionFrom
)

@Serializable
data class EquipmentOptionFrom (
    @SerialName("equipment_category")
    val equipmentCategory: Proficiency
)
