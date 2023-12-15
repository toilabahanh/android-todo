package com.bahanh.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bahanh.todo.theme.TodoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TodoTheme {
                AndroidViewInLazyList()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AndroidViewInLazyList() {
    LazyColumn(modifier = Modifier.background(Color.Black).fillMaxSize()) {
        items(100) {
            _ -> Button(onClick = { /*TODO*/ }, content = {
                Text(text = "Dat dep")
        })
        }
    }
}

