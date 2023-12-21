package com.example.todo.view.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.viewmodels.TodoViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    todoViewModel: TodoViewModel = viewModel(),
){
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