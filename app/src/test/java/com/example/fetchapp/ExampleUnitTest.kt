package com.example.fetchapp

import com.example.fetchapp.data.model.FetchItem
import com.example.fetchapp.data.repository.FetchRepository
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val repository = FetchRepository()

    @Test
    fun testExtractNumberCorrectly() {
        assertEquals(27, repository.extractNumber("Item 27"))
        assertEquals(5, repository.extractNumber("Item 5"))
        assertEquals(null, repository.extractNumber("Unknown Item"))
    }

    @Test
    fun testFilteringRemovesBlankNamesSimply() {
        val items = listOf(
            FetchItem(id = 1, listId = 1, name = "Item 1"),
            FetchItem(id = 2, listId = 1, name = ""),
            FetchItem(id = 3, listId = 2, name = " "),
            FetchItem(id = 4, listId = 2, name = null),
            FetchItem(id = 5, listId = 3, name = "Item 5")
        )

        val filtered = items.filter { !it.name.isNullOrBlank() }

        assertEquals(2, filtered.size)
        assertEquals("Item 1", filtered[0].name)
        assertEquals("Item 5", filtered[1].name)
    }

}