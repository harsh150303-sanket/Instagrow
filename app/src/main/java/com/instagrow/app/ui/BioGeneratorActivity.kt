package com.instagrow.app.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instagrow.app.R
import com.instagrow.app.adapter.TextItemAdapter
import com.instagrow.app.data.LocalData

class BioGeneratorActivity : BaseGeneratorActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bio_generator)

        val businessTypeInput = findViewById<EditText>(R.id.businessTypeInput)
        val styleInput = findViewById<AutoCompleteTextView>(R.id.styleInput)
        val generateButton = findViewById<Button>(R.id.generateBioBtn)
        val recyclerView = findViewById<RecyclerView>(R.id.bioRecycler)
        val loading = findViewById<ProgressBar>(R.id.loading)

        styleInput.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, LocalData.bioStyles))

        val adapter = TextItemAdapter(onCopy = ::copyText)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        generateButton.setOnClickListener {
            loading.visibility = View.VISIBLE
            val style = styleInput.text.toString().ifBlank { LocalData.bioStyles.first() }
            val bios = LocalData.generateBios(businessTypeInput.text.toString(), style)
            adapter.updateData(bios)
            loading.visibility = View.GONE
        }
    }
}
