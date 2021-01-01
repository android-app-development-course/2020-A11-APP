package com.example.random.ui.dice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.random_1.R

class DiceFragment : Fragment() {

    private lateinit var diceViewModel: DiceViewModel



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        diceViewModel =
                ViewModelProvider(this).get(DiceViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dice, container, false)
        updateRecycler(root)

        root.findViewById<Button>(R.id.btn_add_dice).setOnClickListener {
            if(diceViewModel.count<9){
                diceViewModel.numberList.add((1..6).random())
                diceViewModel.count+=1
                updateRecycler(root)
            }
        }

        root.findViewById<Button>(R.id.btn_reduce_dice).setOnClickListener {
            if(diceViewModel.count>1){
                diceViewModel.numberList.removeAt(diceViewModel.numberList.size-1)
                diceViewModel.count-=1
                updateRecycler(root)
            }
        }

        root.findViewById<Button>(R.id.btn_roll).setOnClickListener {
            diceViewModel.numberList.removeAll(diceViewModel.numberList)
            for(i in 1..diceViewModel.count){
                diceViewModel.numberList.add((1..6).random())
            }
            updateRecycler(root)
        }

        return root
    }

    private fun updateRecycler(view: View){
        view.findViewById<RecyclerView>(R.id.recyclerView_dice).layoutManager=
                StaggeredGridLayoutManager(when(diceViewModel.count){
                    1->1
                    2->2
                    else->3
                },StaggeredGridLayoutManager.VERTICAL)
        val adapter= DiceAdapter(diceViewModel.numberList)
        view.findViewById<RecyclerView>(R.id.recyclerView_dice).adapter=adapter
    }
}