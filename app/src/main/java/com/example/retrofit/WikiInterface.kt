package com.example.retrofit

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://en.wikipedia.org/w/api.php?action=query&format=json&list=search&srsearch=Trump

const val BASE_URL ="https://en.wikipedia.org"
interface WikiInterface {

    @GET("/w/api.php?action=query&format=json&list=search")
    suspend fun getHits(@Query("srsearch") name: String): Response<Result>
}

object WikiService {
    val wikiInstance: WikiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        wikiInstance = retrofit.create(WikiInterface::class.java)
    }
}