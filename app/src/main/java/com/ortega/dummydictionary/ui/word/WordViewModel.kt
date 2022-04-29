package com.ortega.dummydictionary.ui.word

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ortega.dummydictionary.data.model.Word
import com.ortega.dummydictionary.repository.DictionaryRepository
import kotlinx.coroutines.launch

class WordViewModel(private val repository: DictionaryRepository): ViewModel() {
    val words = repository.getAllWords()

    fun addWord(word: Word) {
        viewModelScope.launch {
            repository.addWord(word)
        }
    }
}