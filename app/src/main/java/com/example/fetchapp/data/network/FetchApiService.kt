/**
 * FetchApiService.kt
 *
 * Retrofit API service interface defining network endpoints.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.data.network
import com.example.fetchapp.data.model.FetchItem
import retrofit2.http.GET

interface FetchApiService {
    @GET("hiring.json")
    suspend fun getItems(): List<FetchItem>
}