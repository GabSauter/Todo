package com.example.todo.view.main.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todo.entities.Todo

@Composable
fun TodosList(
    todos: List<Todo>,
    onCheckedChange: (todo: Todo) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ){
        items(todos){todo ->
            TodoItem(
                title = todo.title,
                checked = todo.checked,
                onCheckedChange = {
                    onCheckedChange(todo)
                }
            )
        }
    }
}