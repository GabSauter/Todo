package com.example.todo.view.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TodoItem(title: String, checked: Boolean, onCheckedChange: () -> Unit, modifier: Modifier = Modifier){
    Surface(
        color = MaterialTheme.colorScheme.surface,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 14.dp)
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 16.sp,
                    color = if (checked) MaterialTheme.colorScheme.outline else MaterialTheme.colorScheme.onSurface,
                    textDecoration = if (checked) TextDecoration.LineThrough else TextDecoration.None
                )
            )
            RadioButton(
                selected = checked,
                onClick = onCheckedChange,
                modifier = Modifier.size(20.dp),
            )
        }
    }
}

@Preview(widthDp = 320)
@Composable
fun TodoItemPreview(){
    TodoItem(title = "Title title", checked = false, onCheckedChange = {})
}

@Preview(widthDp = 320)
@Composable
fun TodoItemPreviewChecked(){
    TodoItem(title = "Title title", checked = true, onCheckedChange = {})
}