package com.example.fetchapp.data.network
import com.example.fetchapp.data.model.FetchItem
import retrofit2.http.GET

interface FetchApiService {
    @GET("hiring.json")
    suspend fun getItems(): List<FetchItem>
}