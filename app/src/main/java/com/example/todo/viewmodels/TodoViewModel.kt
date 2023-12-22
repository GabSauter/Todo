package com.example.todo.viewmodels

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.dao.TodoDao
import com.example.todo.db.TodoDatabase
import com.example.todo.entities.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val dao: TodoDao
    var todoTitle: MutableState<String> = mutableStateOf("")
    var todos = mutableStateListOf<Todo>()

    init{
        dao = TodoDatabase.getInstance(application).todoDao()
        loadTodos()
    }

    private fun loadTodos(){
        viewModelScope.launch(Dispatchers.IO) {
            val todosData = dao.getAll()

            withContext(Dispatchers.Main){
                todos.addAll(todosData)
            }
        }
    }

    fun addTodo(todo: Todo){
        todos.add(todo)
        todoTitle.value = ""
        viewModelScope.launch(Dispatchers.IO) {
            dao.add(todo)
        }
    }
    fun updateTodoInput(title: String){
        todoTitle.value = title
    }
    fun onCheckedChange(todo: Todo){
        todo.checked = !todo.checked
    }
}