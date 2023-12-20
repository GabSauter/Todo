package com.example.todo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.todo.entities.Todo

class TodoViewModel: ViewModel() {
    var todos: MutableState<List<Todo>> = mutableStateOf(
        mutableListOf(Todo("Test test"), Todo("Test 2", true))
    )

    fun onCheckedChange(todo: Todo){
        todo.checked = !todo.checked
    }
}