package com.example.task3application.guess

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.task3application.extensions.randomChar
import com.example.task3application.extensions.randomInteger

class GuessViewModel : ViewModel() {

    private val _randomNum: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>().apply {
            value = randomInteger()
        }
    }

    private val randomNum: LiveData<Int> get() = _randomNum

    private val _char: MutableLiveData<Char> by lazy {
        MutableLiveData<Char>().apply {
            value = randomChar()
        }
    }
    val char: LiveData<Char> get() = _char

    fun resetGame() {
        _randomNum.value = randomInteger()
        _char.value = randomChar()
    }

    fun checkGame(number: Int): Boolean {
        return randomNum.value == number
    }
}