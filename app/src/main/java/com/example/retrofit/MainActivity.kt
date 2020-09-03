package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getHits()
    }

    private fun getHits() {
        /*val hits = WikiService.wikiInstance.getHits("Adam")

        hits.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.d("ABC", "Error in fetching", t)
            }

            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                val hits = response.body()?.query?.searchinfo?.totalhits
                if (hits != null) {
                    Log.d("ABC", hits.toString())
                }
            }
        })*/

        GlobalScope.launch(Dispatchers.IO) {
            val hits = WikiService.wikiInstance.getHits("Adam")
            val result = hits.body()
            if (hits.isSuccessful) {
                if (result != null)
                    Log.d("ABC", result.query.searchinfo.totalhits.toString())
            }
        }
    }
}