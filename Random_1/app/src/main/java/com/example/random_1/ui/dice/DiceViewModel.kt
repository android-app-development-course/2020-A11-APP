package com.example.random.ui.dice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    var count:Int=1
    var numberList= mutableListOf<Int>((1..6).random())
}