package com.example.retrofit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel: ViewModel() {

    private val repository: WebServiceRepository = WebServiceRepository()

    val hits = liveData(Dispatchers.IO) {
        val retrievedHits = repository.getHits("Donald Trump")

        emit(retrievedHits)
    }
}