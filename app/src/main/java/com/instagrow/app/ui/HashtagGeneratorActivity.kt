package com.instagrow.app.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instagrow.app.R
import com.instagrow.app.adapter.TextItemAdapter
import com.instagrow.app.data.LocalData

class HashtagGeneratorActivity : BaseGeneratorActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hashtag_generator)

        val keywordInput = findViewById<EditText>(R.id.keywordInput)
        val generateButton = findViewById<Button>(R.id.generateHashtagBtn)
        val recyclerView = findViewById<RecyclerView>(R.id.hashtagRecycler)
        val loading = findViewById<ProgressBar>(R.id.loading)

        val adapter = TextItemAdapter(onCopy = ::copyText)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        generateButton.setOnClickListener {
            loading.visibility = View.VISIBLE
            val hashtags = LocalData.generateHashtags(keywordInput.text.toString())
            adapter.updateData(hashtags)
            loading.visibility = View.GONE
        }
    }
}
