package com.example.random.ui.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CoinViewModel : ViewModel() {
    var count:Int=1
    var numberList= mutableListOf<Int>((1..6).random())

}