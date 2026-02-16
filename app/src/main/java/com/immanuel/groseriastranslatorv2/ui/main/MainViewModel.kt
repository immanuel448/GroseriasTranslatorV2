package com.immanuel.groseriastranslatorv2.ui.main

import androidx.lifecycle.ViewModel
import com.immanuel.groseriastranslatorv2.data.model.Word
import com.immanuel.groseriastranslatorv2.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {

    private val repository = WordRepository()

    // Idiomas seleccionados
    private val _languageFrom = MutableStateFlow("en")
    val languageFrom: StateFlow<String> = _languageFrom.asStateFlow()

    private val _languageTo = MutableStateFlow("es")
    val languageTo: StateFlow<String> = _languageTo.asStateFlow()

    // Palabras del idioma origen
    private val _words = MutableStateFlow(
        repository.getWords(_languageFrom.value)
    )
    val words: StateFlow<List<Word>> = _words.asStateFlow()

    // Palabra seleccionada
    private val _selectedWord = MutableStateFlow<Word?>(null)
    val selectedWord: StateFlow<Word?> = _selectedWord.asStateFlow()

    // Traducciones
    private val _translations = MutableStateFlow<List<Word>>(emptyList())
    val translations: StateFlow<List<Word>> = _translations.asStateFlow()

    fun selectWord(word: Word) {
        _selectedWord.value = word
        _translations.value =
            repository.getTranslations(word, _languageTo.value)
    }

    fun changeLanguages(from: String, to: String) {
        _languageFrom.value = from
        _languageTo.value = to

        _words.value = repository.getWords(from)
        _selectedWord.value = null
        _translations.value = emptyList()
    }

    fun setLanguageTo(languageCode: String) {
        _languageTo.value = languageCode

        _selectedWord.value?.let { word ->
            _translations.value =
                repository.getTranslations(word, languageCode)
        }
    }

}
