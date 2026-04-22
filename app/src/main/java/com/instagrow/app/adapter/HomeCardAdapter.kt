package com.instagrow.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.instagrow.app.R
import com.instagrow.app.model.HomeCard

class HomeCardAdapter(
    private val items: List<HomeCard>,
    private val onClick: (HomeCard) -> Unit
) : RecyclerView.Adapter<HomeCardAdapter.HomeCardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home_card, parent, false)
        return HomeCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeCardViewHolder, position: Int) {
        val card = items[position]
        holder.title.text = card.title
        holder.card.setOnClickListener { onClick(card) }
    }

    override fun getItemCount(): Int = items.size

    class HomeCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val card: MaterialCardView = itemView.findViewById(R.id.homeCard)
        val title: TextView = itemView.findViewById(R.id.cardTitle)
    }
}
