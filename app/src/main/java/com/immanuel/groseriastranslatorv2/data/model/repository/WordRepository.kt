package com.immanuel.groseriastranslatorv2.data.repository

import com.immanuel.groseriastranslatorv2.data.model.Word

class WordRepository {

    // Datos fake para pruebas
    private val words = listOf(
        Word(
            id = 1,
            conceptId = 1,
            languageCode = "en",
            text = "fuck",
            partOfSpeech = com.immanuel.groseriastranslatorv2.data.model.common.PartOfSpeech.VERB,
            variantType = com.immanuel.groseriastranslatorv2.data.model.common.VariantType.BASE,
            intensity = 5
        ),
        Word(
            id = 2,
            conceptId = 1,
            languageCode = "es",
            text = "joder",
            partOfSpeech = com.immanuel.groseriastranslatorv2.data.model.common.PartOfSpeech.VERB,
            variantType = com.immanuel.groseriastranslatorv2.data.model.common.VariantType.BASE,
            intensity = 4
        ),
        Word(
            id = 3,
            conceptId = 2,
            languageCode = "en",
            text = "shit",
            partOfSpeech = com.immanuel.groseriastranslatorv2.data.model.common.PartOfSpeech.NOUN,
            variantType = com.immanuel.groseriastranslatorv2.data.model.common.VariantType.BASE,
            intensity = 4
        ),
        Word(
            id = 4,
            conceptId = 2,
            languageCode = "es",
            text = "mierda",
            partOfSpeech = com.immanuel.groseriastranslatorv2.data.model.common.PartOfSpeech.NOUN,
            variantType = com.immanuel.groseriastranslatorv2.data.model.common.VariantType.BASE,
            intensity = 3
        )
    )

    fun getWords(languageCode: String): List<Word> {
        return words.filter { it.languageCode == languageCode }
    }

    fun getWordById(id: Int): Word? {
        return words.find { it.id == id }
    }

    fun getTranslations(word: Word, targetLanguage: String): List<Word> {
        return words.filter {
            it.conceptId == word.conceptId &&
                    it.languageCode == targetLanguage
        }
    }
}
