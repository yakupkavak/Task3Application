package com.example.task3application.counter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    val counterNum: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = 0
        }
    }
    fun incrementCount(){
        counterNum.value?.let {
            counterNum.value = it + 1
        }
    }

}