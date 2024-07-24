package com.example.task3application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _sharedChar: MutableLiveData<Char> by lazy {
        MutableLiveData<Char>()
    }

    val sharedChar: LiveData<Char> get() = _sharedChar

    fun updateChar(char: Char) {
        _sharedChar.value = char
    }
}