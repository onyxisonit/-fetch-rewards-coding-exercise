/**
 * RetrofitInstance.kt
 *
 * Singleton object to create and provide a Retrofit instance for API calls.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://hiring.fetch.com/"

    val api: FetchApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FetchApiService::class.java)
    }
}