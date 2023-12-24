package com.example.todo.view.main

import android.app.Application
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.todo.view.main.components.AddTodo
import com.example.todo.view.main.components.TodosList
import com.example.todo.viewmodels.TodoViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    val application = LocalContext.current.applicationContext as Application
    val todoViewModel = TodoViewModel(application)

    Scaffold(
        bottomBar = {
            AddTodo(
                title = todoViewModel.todoTitle.value,
                updateInput = { newTitle -> todoViewModel.updateTodoInput(newTitle) },
                addTodo = { todo -> todoViewModel.addTodo(todo) }
            )
        },
        modifier = modifier
    ) { padding ->
        TodosList(
            todos = todoViewModel.todos,
            onCheckedChange = { todo -> todoViewModel.onCheckedChange(todo) },
            modifier = Modifier.padding(padding)
        )
    }
}