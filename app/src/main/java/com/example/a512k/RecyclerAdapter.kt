package com.example.a512k

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView

class RecyclerAdapter(var context: Context, var list: ArrayList<ItemModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_rv, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemModel = list[position]
        holder.lottieAnimationView.setAnimation(itemModel.getLottieId())
        holder.description.text = itemModel.getDescription()
        holder.title.text = itemModel.getTitle()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lottieAnimationView: LottieAnimationView
        var title: TextView
        var description: TextView

        init {
            lottieAnimationView = itemView.findViewById(R.id.lottie)
            title = itemView.findViewById(R.id.heading)
            description = itemView.findViewById(R.id.description)
        }
    }
}