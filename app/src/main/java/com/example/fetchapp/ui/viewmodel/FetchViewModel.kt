/**
 * FetchViewModel.kt
 *
 * ViewModel for managing sections grouped by listId,
 * fetching data through the repository, and exposing it to the UI layer.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchapp.data.model.FetchItem
import com.example.fetchapp.data.model.Section
import com.example.fetchapp.data.repository.FetchRepository
import kotlinx.coroutines.launch

class FetchViewModel(private val repository: FetchRepository  = FetchRepository()) : ViewModel() {


    private val _sections = MutableLiveData<List<Section>>()
    val sections: LiveData<List<Section>> = _sections

    init {
        viewModelScope.launch {
            val items = repository.getFilteredItems()

            val groupedItems = items.groupBy { it.listId }
            val sectionList = groupedItems.map { (listId, items) ->
                Section(
                    listId = listId,
                    isExpanded = false,
                    items = items.sortedBy { extractNumber(it.name) }
                )
            }.sortedBy { it.listId }

            //See All Section
            val seeAllSection = Section(
                listId = -1,
                isExpanded = false,
                items = items.sortedWith(compareBy({ it.listId }, { extractNumber(it.name) }))
            )

            val finalSections = mutableListOf<Section>()
            finalSections.add(seeAllSection)
            finalSections.addAll(sectionList)

            _sections.value = finalSections
        }
    }

    private fun extractNumber(name: String?): Int {
        return name?.substringAfter("Item ")?.toIntOrNull() ?: Int.MAX_VALUE
    }
}


