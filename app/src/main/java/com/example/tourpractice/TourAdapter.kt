package com.example.tourpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TourAdapter (
    private val context: Context,
    private val tour: List<DataTour>,
    val listener: (DataTour) -> Unit ) :RecyclerView.Adapter<TourAdapter.TourViewHolder>() {
    class TourViewHolder (view: View): RecyclerView.ViewHolder(view){
        val image_tour = view.findViewById<ImageView>(R.id.img_item_photo)
        val tour_name = view.findViewById<TextView>(R.id.tv_item_name)
        val tour_description = view.findViewById<TextView>(R.id.tv_item_description)
        fun bindView(dataTour: DataTour, listener: (DataTour) -> Unit) {
            image_tour.setImageResource(dataTour.image_tour)
            tour_name.text = dataTour.tour_name
            tour_description.text = dataTour.tour_description
            itemView.setOnClickListener {
                listener(dataTour)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourViewHolder {
        return TourViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_tour, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TourViewHolder, position: Int) {
        holder.bindView(tour[position], listener)
    }

    override fun getItemCount(): Int = tour.size
    }
