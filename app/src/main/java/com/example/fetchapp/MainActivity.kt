package com.example.fetchapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fetchapp.ui.theme.FetchAppTheme
import com.example.fetchapp.ui.view.FetchAdapter
import com.example.fetchapp.ui.view.SectionAdapter
import com.example.fetchapp.ui.viewmodel.FetchViewModel

class MainActivity : ComponentActivity() {

    private lateinit var fetchViewModel: FetchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchViewModel = ViewModelProvider(this)[FetchViewModel::class.java]

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = SectionAdapter()
        recyclerView.adapter = adapter

        fetchViewModel.sections.observe(this) { sections ->
            adapter.submitList(sections)
        }

    }
}
