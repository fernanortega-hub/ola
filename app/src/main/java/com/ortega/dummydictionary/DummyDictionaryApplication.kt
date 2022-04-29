package com.ortega.dummydictionary

import android.app.Application
import com.ortega.dummydictionary.data.DummyDictionaryDatabase
import com.ortega.dummydictionary.repository.DictionaryRepository

class DummyDictionaryApplication : Application() {
    val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }

    fun getDictionaryRepository() = with(dataBase) {
        DictionaryRepository(wordDao(), synonymDao(), antonymDao())
    }
}