package com.example.tourpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tourList = listOf<DataTour>(
            DataTour(
                R.drawable.danau_toba,
                "Danau Toba",
                "Danau Toba adalah danau terbesar di Indonesia dan juga di Asia Tenggara. Danau ini terletak di Sumatera Utara, Indonesia. Danau ini berada di dalam kawasan pegunungan, dan terletak di antara dua pegunungan, yaitu Pegunungan Barisan dan Pegunungan Toba. Danau ini berada di atas ketinggian 1.300 meter di atas permukaan laut."
            ),
            DataTour(
                R.drawable.gunung_rinjani,
                "Gunung Rinjani",
                "Gunung Rinjani adalah gunung berapi yang terletak di Pulau Lombok, Nusa Tenggara Barat, Indonesia. Gunung ini merupakan gunung berapi tertinggi kedua di Indonesia setelah Gunung Kerinci di Sumatra. Gunung ini juga merupakan gunung berapi tertinggi di Pulau Lombok dan Pulau Bali. Gunung ini memiliki ketinggian 3.726 meter di atas permukaan laut."
            ),
            DataTour(
                R.drawable.kepulauan_derawan,
                "Kepulauan Derawan",
                "Kepulauan Derawan adalah sebuah kawasan wisata di Kalimantan Timur, Indonesia. Kepulauan ini terdiri dari 13 pulau, yaitu Pulau Derawan, Pulau Kakaban, Pulau Maratua, Pulau Berau, Pulau Berau Besar, Pulau Berau Kecil, Pulau Berau Tengah, Pulau Berau Utara, Pulau Berau Selatan, Pulau Berau Timur, Pulau Berau Barat, Pulau Berau Tenggara, dan Pulau Berau Tenggara. Kepulauan Derawan terletak di sebelah barat laut Pulau Kalimantan."
            ),
            DataTour(
                R.drawable.nusa_dua_bali,
                "Nusa Dua Bali",
                "Nusa Dua adalah sebuah kawasan wisata di Bali, Indonesia. Nusa Dua terletak di sebelah timur Pulau Bali. Nusa Dua terdiri dari beberapa kawasan wisata, yaitu Nusa Dua Beach, Nusa Dua Convention Center, Nusa Dua Golf Club, dan Nusa Dua Theater. Nusa Dua juga terkenal dengan pantai-pantainya yang indah."
            ),
            DataTour(
                R.drawable.nusa_penida,
                "Nusa Penida",
                "Nusa Penida adalah sebuah pulau di Bali, Indonesia. Nusa Penida terletak di sebelah timur Pulau Bali. Nusa Penida terdiri dari beberapa pulau kecil, yaitu Pulau Nusa Penida, Pulau Nusa Lembongan, Pulau Nusa Ceningan, Pulau Nusa Kembangan, Pulau Nusa Penida Kecil, Pulau Nusa Penida Besar, Pulau Nusa Penida Tengah, Pulau Nusa Penida Utara, Pulau Nusa Penida Selatan, Pulau Nusa Penida Timur, Pulau Nusa Penida Barat, Pulau Nusa Penida Tenggara, dan Pulau Nusa Penida Barat Daya."
            ),
            DataTour(
                R.drawable.pantai_parai_tenggiri,
                "Pantai Parai Tenggiri",
                "Pantai Parai Tenggiri adalah sebuah pantai di Pulau Lombok, Nusa Tenggara Barat, Indonesia. Pantai ini terletak di sebelah barat Pulau Lombok. Pantai ini memiliki pasir putih dan pantai ini juga memiliki pemandangan laut yang indah. Pantai ini terletak di sebelah barat Pulau Lombok. Pantai ini berada di antara dua gunung, yaitu Gunung Rinjani dan Gunung Batu Karu. Pantai ini memiliki pasir putih dan pantai ini juga memiliki pemandangan laut yang indah. Pantai ini memiliki panjang sekitar 500 meter dan lebar sekitar 150 meter. Pantai ini memiliki pasir putih dan pantai ini juga memiliki pemandangan laut yang indah. Pantai ini memiliki panjang sekitar 500 meter dan lebar sekitar 150 meter."
            ),
            DataTour(
                R.drawable.pura_besakih,
                "Pura Besakih",
                "Pura Besakih adalah sebuah pura Hindu di Bali, Indonesia. Pura Besakih terletak di sebelah timur Pulau Bali. Pura Besakih terletak di sebelah timur Pulau Bali. Pura Besakih terletak di sebelah timur Pulau Bali. Pura Besakih terletak di sebelah timur Pulau Bali. Pura Besakih terletak di sebelah timur Pulau Bali. Pura Besakih terletak di sebelah timur Pulau Bali."
            ),
            DataTour(
                R.drawable.taman_laut_bunaken,
                "Taman Laut Bunaken",
                "Taman Laut Bunaken adalah sebuah taman laut di Sulawesi Utara, Indonesia. Taman laut ini terletak di sebelah utara Pulau Sulawesi. Taman laut ini terletak di sebelah utara Pulau Sulawesi. Taman laut ini terletak di sebelah utara Pulau Sulawesi. Taman laut ini terletak di sebelah utara Pulau Sulawesi. Taman laut ini terletak di sebelah utara Pulau Sulawesi."
            ),
            DataTour(
                R.drawable.taman_nasional_way_kambas,
                "Taman Nasional Way Kambas",
                "Taman Nasional Way Kambas adalah sebuah taman nasional di Sumatera Selatan, Indonesia. Taman Nasional Way Kambas terletak di sebelah barat Pulau Sumatera. Taman Nasional Way Kambas terletak di sebelah barat Pulau Sumatera. Taman Nasional Way Kambas terletak di sebelah barat Pulau Sumatera."
            ),
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_tour)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = TourAdapter(this, tourList) {
            val intent =  Intent(this, DetailTourActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}