/**
 * FetchItem.kt
 *
 * Data class representing a single item fetched from the API.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.data.model

data class FetchItem (
    val id: Int,
    val listId: Int,
    val name: String?
)