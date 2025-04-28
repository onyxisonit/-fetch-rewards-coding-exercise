/**
 * FetchRepository.kt
 *
 * Repository layer responsible for fetching data from the API and filtering/sorting it
 * before exposing it to the ViewModel.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.data.repository

import com.example.fetchapp.data.model.FetchItem
import com.example.fetchapp.data.network.RetrofitInstance

/**
* below, I am sorting assuming name is in consistent format of "Item number"
* (since I have access to the entire dataset and it is a small dataset)
* if we did not have direct access to the data/ it was a larger dataset we can use a custom comparator instead:

//.sortedWith(
//    compareBy<FetchItem> { it.listId }
//    .thenComparator { a, b ->
//        val aNum = extractNumber(a.name)
//        val bNum = extractNumber(b.name)
//
//        when {
//            aNum != null && bNum != null -> aNum.compareTo(bNum)   // both have numbers → compare by number
//            aNum != null -> -1                                    // a has number → a first
//            bNum != null -> 1                                     // b has number → b first
//            else -> (a.name ?: "").compareTo(b.name ?: "")        // neither have number → compare names ascending
//        }
//    }
// )
* */

class FetchRepository {
    suspend fun getFilteredItems() : List<FetchItem> {
        return RetrofitInstance.api.getItems()
            .filter { !it.name.isNullOrBlank() }
            .sortedWith( compareBy ({ it.listId }, { extractNumber(it.name) }) )
    }

    fun extractNumber(name: String?): Int? {
        return name
            ?.substringAfter("Item ")
            ?.toIntOrNull()
    }
}


