package com.bahanh.todo.tasks

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bahanh.todo.data.Task
import com.bahanh.todo.theme.TodoTheme
import com.bahanh.todo.util.LoadingContent
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    onTaskClick: (Task) -> Unit,
) {
    Scaffold() {
//        TasksContent()
    }
}

@Composable
fun TasksContent(
    loading: Boolean, tasks: List<Task>, modifier: Modifier = Modifier
) {
    LoadingContent(empty = tasks.isEmpty() && !loading, emptyContent = { /*TODO*/ }) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(
                    horizontal = 20.dp
                )
        ) {
            LazyColumn {
                items(tasks) { task ->
                    TaskItem(task = task, onTaskClick = {})
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TaskItem(task: Task, onTaskClick: (Task) -> Unit) {
    val backgroundColor =
        Color(
            red = Random.nextInt(256),
            green = Random.nextInt(256),
            blue = Random.nextInt(256),
            alpha = 80
        )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(onClick = { onTaskClick(task) }, onLongClick = {})
            .padding(vertical = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .defaultMinSize(minHeight = 80.dp)
                .clip(shape = MaterialTheme.shapes.small)
                .background(backgroundColor)
        ) {
            Text(
                text = task.titleForList,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp),
                textDecoration = if (task.isCompleted) {
                    TextDecoration.LineThrough
                } else null,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )

        }
    }
}

@Composable
private fun TasksEmptyContent(
    @StringRes noTasksLabel: Int, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(stringResource(id = noTasksLabel))
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TasksContentPreview() {
    TodoTheme {
        TasksContent(
            loading = false,
            tasks = listOf(
                Task(
                    title = "Title 1",
                    description = "Description 1",
                    isCompleted = false,
                    id = "ID 1"
                ),
                Task(
                    title = "Title 2",
                    description = "Description 2",
                    isCompleted = true,
                    id = "ID 2"
                ),
                Task(
                    title = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    description = "Description 3",
                    isCompleted = true,
                    id = "ID 3"
                ),
                Task(
                    title = "Title 4",
                    description = "Description 4",
                    isCompleted = false,
                    id = "ID 4"
                ),
                Task(
                    title = "Title 5",
                    description = "Description 5",
                    isCompleted = true,
                    id = "ID 5"
                ),
            ),
        )
    }
}
