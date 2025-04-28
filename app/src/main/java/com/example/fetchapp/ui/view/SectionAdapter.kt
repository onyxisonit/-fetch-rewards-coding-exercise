/**
 * SectionAdapter.kt
 *
 * RecyclerView Adapter to display sections grouped by listId, supporting expandable and collapsible headers.
 * Manages headers and item view types dynamically.
 *
 * Created by onyxisonit in 2025.
 * Licensed for Fetch Rewards coding exercise submission.
 */

package com.example.fetchapp.ui.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapp.R
import com.example.fetchapp.data.model.FetchItem
import com.example.fetchapp.data.model.Section

class SectionAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val sections = mutableListOf<Section>()

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    fun submitList(newSections: List<Section>) {
        sections.clear()
        sections.addAll(newSections)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        var currentPos = 0
        for (section in sections) {
            if (position == currentPos) return TYPE_HEADER
            currentPos++

            if (section.isExpanded) {
                if (position < currentPos + section.items.size) {
                    return TYPE_ITEM
                }
                currentPos += section.items.size
            }
        }
        throw IllegalStateException("Unknown view type for position $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.section_header, parent, false)
            SectionHeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
            SectionItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var currentPos = 0
        for (sectionIndex in sections.indices) {
            val section = sections[sectionIndex]

            if (position == currentPos) {
                (holder as SectionHeaderViewHolder).bind(section)
                return
            }
            currentPos++

            if (section.isExpanded) {
                if (position < currentPos + section.items.size) {
                    val item = section.items[position - currentPos]
                    (holder as SectionItemViewHolder).bind(item)
                    return
                }
                currentPos += section.items.size
            }
        }
    }

    override fun getItemCount(): Int {
        var count = 0
        for (section in sections) {
            count++
            if (section.isExpanded) {
                count += section.items.size
            }
        }
        return count
    }

    inner class SectionHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val headerText: TextView = itemView.findViewById(R.id.headerText)
        private val arrowIcon: ImageView = itemView.findViewById(R.id.arrowIcon)

        fun bind(section: Section) {
            headerText.text = if (section.listId == -1) {
                "See All"
            } else {
                "List ID: ${section.listId}"
            }

            setArrowRotation(section.isExpanded)

            itemView.setOnClickListener {
                val wasExpanded = section.isExpanded
                // Collapse all other sections before expanding clicked section
                for (sec in sections) {
                    sec.isExpanded = false
                }
                section.isExpanded = !wasExpanded
                notifyDataSetChanged()
            }
        }


        private fun setArrowRotation(isExpanded: Boolean) {
            arrowIcon.rotation = if (isExpanded) 180f else 0f
        }
    }


    inner class SectionItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemText: TextView = itemView.findViewById(R.id.itemText)

        fun bind(item: FetchItem) {
            itemText.text = itemView.context.getString(
                R.string.item_text,
                item.listId,
                item.name
            )
        }
    }
}
