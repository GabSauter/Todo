package com.example.todo.view.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todo.entities.Todo

@Composable
fun AddTodo(
    title: String,
    updateInput: (title: String) -> Unit,
    addTodo: (todo: Todo) -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(10.dp)
    ){
        OutlinedTextField(
            value = title,
            onValueChange = { title -> updateInput(title) },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
        )
        IconButton(
            onClick = { addTodo(Todo(title = title)) },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
                .size(58.dp)
        ) {
            Icon(
                Icons.Filled.Add, contentDescription = "Add Todo",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}