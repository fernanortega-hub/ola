package com.ortega.dummydictionary.repository

import androidx.lifecycle.MutableLiveData
import com.ortega.dummydictionary.data.dao.AntonymDao
import com.ortega.dummydictionary.data.dao.SynonymDao
import com.ortega.dummydictionary.data.dao.WordDao
import com.ortega.dummydictionary.data.model.Word

class DictionaryRepository(
    private val wordDoa: WordDao,
    val synonymDao: SynonymDao,
    val antonymDao: AntonymDao
) {

    fun getAllWords() = wordDoa.getAllWords()

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }
}