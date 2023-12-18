package com.example.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.view.main.TodoItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                TodoItem(title = "Test test", checked = true, onCheckedChange = { /*TODO*/ })
            }
        }
    }
}