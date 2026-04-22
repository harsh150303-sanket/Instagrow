package com.instagrow.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.instagrow.app.R

class TextItemAdapter(
    private var items: List<String> = emptyList(),
    private val onCopy: (String) -> Unit
) : RecyclerView.Adapter<TextItemAdapter.TextViewHolder>() {

    fun updateData(newItems: List<String>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text_result, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item
        holder.copyButton.setOnClickListener { onCopy(item) }
    }

    override fun getItemCount(): Int = items.size

    class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.resultText)
        val copyButton: ImageButton = itemView.findViewById(R.id.copyButton)
    }
}
