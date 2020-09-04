package com.example.retrofit

class WebServiceRepository() {

    private val call = WikiApi.service

    suspend fun getHits(name: String) = call.getHits(name)
}