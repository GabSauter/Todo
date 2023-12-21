package com.example.todo.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.todo.entities.Todo

class TodoViewModel: ViewModel() {
    var todoTitle: MutableState<String> = mutableStateOf("")
    var todos: MutableList<Todo> = mutableStateListOf()

    fun addTodo(todo: Todo){
        todos.add(todo)
        todoTitle.value = ""
    }
    fun updateTodoInput(title: String){
        todoTitle.value = title
    }
    fun onCheckedChange(todo: Todo){
        todo.checked = !todo.checked
    }
}