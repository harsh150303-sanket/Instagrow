package com.instagrow.app.ui

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instagrow.app.R
import com.instagrow.app.adapter.TextItemAdapter
import com.instagrow.app.data.LocalData

class CaptionGeneratorActivity : BaseGeneratorActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caption_generator)

        val categoryInput = findViewById<AutoCompleteTextView>(R.id.categoryInput)
        val toneInput = findViewById<AutoCompleteTextView>(R.id.toneInput)
        val generateButton = findViewById<Button>(R.id.generateCaptionBtn)
        val recyclerView = findViewById<RecyclerView>(R.id.captionRecycler)
        val loading = findViewById<ProgressBar>(R.id.loading)

        categoryInput.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, LocalData.categories))
        toneInput.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, LocalData.tones))

        val adapter = TextItemAdapter(onCopy = ::copyText)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        generateButton.setOnClickListener {
            loading.visibility = View.VISIBLE
            val category = categoryInput.text.toString().ifBlank { LocalData.categories.first() }
            val tone = toneInput.text.toString().ifBlank { LocalData.tones.first() }
            val captions = LocalData.generateCaptions(category, tone)
            adapter.updateData(captions)
            loading.visibility = View.GONE
        }
    }
}
