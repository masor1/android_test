package com.sirius.test_app

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.sirius.test_app.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val listOfStarView by lazy {
        listOf(
            binding.star1,
            binding.star2,
            binding.star3,
            binding.star4,
            binding.star5
        )
    }

    private val listOfStarView2 by lazy {
        listOf(
            binding.star11,
            binding.star22,
            binding.star33,
            binding.star44,
            binding.star55
        )
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = DataModel()
        val adapter = CommentAdapter(data.reviews)
        Picasso.get().load(data.image).into(binding.image)
        Picasso.get().load(data.logo).into(binding.logo)
        binding.name.text = data.name
        binding.gradeCnt.text = data.gradeCnt
        binding.gradeCntRating.text = buildString {
            append(data.gradeCnt)
            append(" Reviews")
        }
        for (i in 0..data.rating.toInt()) {
            listOfStarView[i].visibility = View.VISIBLE
            listOfStarView2[i].visibility = View.VISIBLE
        }
        for (tag in data.tags) {
            val cardView = CardView(this)
            cardView.setCardBackgroundColor(getColor(R.color.category_tab))
            cardView.useCompatPadding = true
            cardView.radius = 48F
            val textView = TextView(this)
            textView.setTextColor(getColor(R.color.category_tab_text))
            textView.setPadding(64, 16, 64, 16)
            textView.textSize = 16F
            textView.text = tag
            cardView.addView(textView)
            binding.categoryTabs.addView(cardView)
        }
        binding.description.text = data.description
        binding.ratingNumber.text = data.rating.toString()
        binding.recyclerReviews.adapter = adapter
    }
}