package com.example.random.ui.coin

import android.graphics.drawable.Animatable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.random_1.R

class CoinAdapter(private val numberList:List<Int>): RecyclerView.Adapter<CoinAdapter.CoinHolder>() {

    inner class CoinHolder(view: View): RecyclerView.ViewHolder(view){
        val image: ImageView =view.findViewById(R.id.image)
    }

    override fun getItemCount()=numberList.size

    override fun onBindViewHolder(holder: CoinHolder, position: Int) {
        holder.image.setImageResource(
                when(numberList[position]){
                    1-> R.drawable.to_backside
                    2-> R.drawable.to_frontside
                    else->R.drawable.to_backside
                })
        (holder.image.drawable as Animatable).start()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false)
        return CoinHolder(view)
    }
}