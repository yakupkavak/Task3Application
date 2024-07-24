package com.example.task3application.extensions

fun randomInteger(min: Int, max: Int): Int {
    return (min until max).random()
}

fun randomChar() : Char{
    val allowedChars = ('A'..'Z')
    return allowedChars.random()
}