/**
 * Section.kt
 *
 * Data class representing a group of FetchItem objects under a specific listId.
 * Also tracks expansion state for RecyclerView.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.data.model

data class Section(
    val listId: Int,
    var isExpanded: Boolean = false,
    val items: List<FetchItem>
)
