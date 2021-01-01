package com.example.random.ui.coin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.random_1.R
import com.example.random.ui.dice.DiceAdapter

class CoinFragment : Fragment() {

    private lateinit var coinViewModel: CoinViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        coinViewModel =
                ViewModelProvider(this).get(CoinViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_coin, container, false)
        updateRecycler(root)

        root.findViewById<Button>(R.id.btn_add_coin).setOnClickListener {
            if(coinViewModel.count<9){
                coinViewModel.numberList.add((1..2).random())
                coinViewModel.count+=1
                updateRecycler(root)
            }
        }

        root.findViewById<Button>(R.id.btn_reduce_coin).setOnClickListener {
            if(coinViewModel.count>1){
                coinViewModel.numberList.removeAt(coinViewModel.numberList.size-1)
                coinViewModel.count-=1
                updateRecycler(root)
            }
        }

        root.findViewById<Button>(R.id.btn_toss).setOnClickListener {
            coinViewModel.numberList.removeAll(coinViewModel.numberList)
            for(i in 1..coinViewModel.count){
                coinViewModel.numberList.add((1..2).random())
            }
            updateRecycler(root)
        }

        return root
    }

    private fun updateRecycler(view: View){
        view.findViewById<RecyclerView>(R.id.recyclerView_coin).layoutManager=
                StaggeredGridLayoutManager(when(coinViewModel.count){
                    1->1
                    2->2
                    else->3
                }, StaggeredGridLayoutManager.VERTICAL)
        val adapter= CoinAdapter(coinViewModel.numberList)
        view.findViewById<RecyclerView>(R.id.recyclerView_coin).adapter=adapter
    }
}