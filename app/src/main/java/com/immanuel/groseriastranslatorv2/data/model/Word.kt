package com.immanuel.groseriastranslatorv2.data.model

import com.immanuel.groseriastranslatorv2.data.model.common.PartOfSpeech
import com.immanuel.groseriastranslatorv2.data.model.common.VariantType

data class Word(
    val id: Int,
    val conceptId: Int,
    val languageCode: String,
    val text: String,
    val partOfSpeech: PartOfSpeech,
    val variantType: VariantType,
    val intensity: Int,
    val examples: List<String> = emptyList()
)
