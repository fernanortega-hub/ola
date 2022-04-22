package com.ortega.dummydictionary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordViewModel(private val repository: DictionaryRepository): ViewModel() {
    val words = repository.words



    fun addWordVM(word: Word) {
        repository.addWord(word)
    }


}