package com.example.random.ui.dice

import android.graphics.drawable.Animatable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.random_1.R

class DiceAdapter(private val numberList:List<Int>):RecyclerView.Adapter<DiceAdapter.DiceHolder>() {

    inner class DiceHolder(view: View):RecyclerView.ViewHolder(view){
        val image:ImageView=view.findViewById(R.id.image)
    }

    override fun getItemCount()=numberList.size

    override fun onBindViewHolder(holder: DiceHolder, position: Int) {
        holder.image.setImageResource(
                when(numberList[position]){
                    1-> R.drawable.to_dice1
                    2-> R.drawable.to_dice2
                    3-> R.drawable.to_dice3
                    4-> R.drawable.to_dice4
                    5-> R.drawable.to_dice5
                    6-> R.drawable.to_dice6
                    else -> R.drawable.to_dice1
                })
        (holder.image.drawable as Animatable).start()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiceHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.image_item,parent,false)
        return DiceHolder(view)
    }
}