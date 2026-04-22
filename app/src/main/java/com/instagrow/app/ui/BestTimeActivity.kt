package com.instagrow.app.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import com.instagrow.app.R
import com.instagrow.app.data.LocalData

class BestTimeActivity : BaseGeneratorActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_time)

        val categoryInput = findViewById<AutoCompleteTextView>(R.id.categoryInput)
        val showButton = findViewById<Button>(R.id.showTimeBtn)
        val output = findViewById<TextView>(R.id.timeOutput)

        categoryInput.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, LocalData.categories))

        showButton.setOnClickListener {
            val category = categoryInput.text.toString().ifBlank { LocalData.categories.first() }
            val times = LocalData.bestPostingTimes(category)
            output.text = times.joinToString(separator = "\n")
        }
    }
}
