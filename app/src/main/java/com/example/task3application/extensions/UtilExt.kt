package com.example.task3application.extensions

fun randomIntegerZeroToTen(): Int {
    return (0 until 10).random()
}

fun randomChar() : Char{ return ('A'..'Z').random() }