package com.example.fetchapp.data.model

data class Section(
    val listId: Int,
    var isExpanded: Boolean = false,
    val items: List<FetchItem>
)
