package com.example.todo.view.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todo.viewmodels.TodoViewModel

@Composable
fun TodosList(
    modifier: Modifier = Modifier,
    todoViewModel: TodoViewModel = viewModel()
){
    LazyColumn{
        items(todoViewModel.todos){todo ->
            TodoItem(title = todo.title, checked = todo.checked, onCheckedChange = {})
        }
    }
}