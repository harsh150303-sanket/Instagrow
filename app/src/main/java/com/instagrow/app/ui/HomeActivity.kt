package com.instagrow.app.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instagrow.app.R
import com.instagrow.app.adapter.HomeCardAdapter
import com.instagrow.app.model.HomeCard

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val cards = listOf(
            HomeCard("Caption Generator", CaptionGeneratorActivity::class.java),
            HomeCard("Hashtag Generator", HashtagGeneratorActivity::class.java),
            HomeCard("Bio Generator", BioGeneratorActivity::class.java),
            HomeCard("Best Time to Post", BestTimeActivity::class.java)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.homeRecycler)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = HomeCardAdapter(cards) { card ->
            startActivity(Intent(this, card.destination))
        }
    }
}
