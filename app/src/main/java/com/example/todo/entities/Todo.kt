package com.example.todo.entities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Todo(val title: String, val initialCheck: Boolean = false){
    var checked by mutableStateOf(initialCheck)
}