package com.example.todo.viewmodels

import androidx.lifecycle.ViewModel
import com.example.todo.entities.Todo

class TodoViewModel: ViewModel() {
    var todos: List<Todo> = mutableListOf(Todo("Test test"), Todo("Test 2", true))
}