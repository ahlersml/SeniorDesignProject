package com.example.seniordesignproject

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var selectedTab : MutableState<String> = mutableStateOf("Rooms")

}



//val roomsTabIsOn by remember {mutableStateOf(true)}
//    val upcomingTasksIsOn by remember {mutableStateOf(false)}
//    val commonTasksIsOn by remember {mutableStateOf(false)}