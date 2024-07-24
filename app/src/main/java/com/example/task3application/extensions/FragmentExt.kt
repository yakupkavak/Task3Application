package com.example.task3application.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

fun Fragment.navigate(action: NavDirections){
    findNavController().navigate(action)
}
fun Fragment.popBackStack(){
    findNavController().popBackStack()
}