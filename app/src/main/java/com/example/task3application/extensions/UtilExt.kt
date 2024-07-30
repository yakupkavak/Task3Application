package com.example.task3application.extensions

fun randomInteger(min: Int = 0, max: Int = 10): Int {
    return (min until max).random()
}

fun randomChar() = ('A'..'Z').random()

