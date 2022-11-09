package com.example.tourpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailTourActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tour)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val  tour = intent.getParcelableExtra<DataTour>(MainActivity.INTENT_PARCELABLE)

        val image_tour  = findViewById<ImageView>(R.id.img_item_photo)
        val tour_name  = findViewById<TextView>(R.id.tv_item_name)
        val tour_description  = findViewById<TextView>(R.id.tv_item_description)

        image_tour.setImageResource(tour?.image_tour!!)
        tour_name.text = tour.tour_name
        tour_description.text = tour.tour_description

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}