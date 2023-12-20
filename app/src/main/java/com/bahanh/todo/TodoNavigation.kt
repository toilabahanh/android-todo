package com.bahanh.todo

import androidx.navigation.NavHostController
import com.bahanh.todo.TodoDestinationsArgs.TASK_ID_ARG
import com.bahanh.todo.TodoDestinationsArgs.USER_MESSAGE_ARG
import com.bahanh.todo.TodoDestinationsArgs.TITLE_ARG
import com.bahanh.todo.TodoScreens.ADD_EDIT_TASK_SCREEN
import com.bahanh.todo.TodoScreens.TASKS_SCREEN
import com.bahanh.todo.TodoScreens.TASK_DETAIL_SCREEN

private object TodoScreens {
    const val TASKS_SCREEN = "tasks"
    const val TASK_DETAIL_SCREEN = "task"
    const val ADD_EDIT_TASK_SCREEN = "addEditTask"
}

object TodoDestinationsArgs {
    const val USER_MESSAGE_ARG = "userMessage"
    const val TASK_ID_ARG = "taskId"
    const val TITLE_ARG = "title"
}

object TodoDestinations {
    const val TASKS_ROUTE = "$TASKS_SCREEN?$USER_MESSAGE_ARG={$USER_MESSAGE_ARG}"
    const val TASK_DETAIL_ROUTE = "$TASK_DETAIL_SCREEN/{$TASK_ID_ARG}"
    const val ADD_EDIT_TASK_ROUTE = "$ADD_EDIT_TASK_SCREEN/{$TITLE_ARG}?$TASK_ID_ARG={$TASK_ID_ARG}"
}

class TodoNavigationActions(private val navHostController: NavHostController) {

    fun navigateToTasks(userMessage: Int = 0) {
        navHostController.navigate(TASKS_SCREEN.let {
            if(userMessage != 0) "$it?$USER_MESSAGE_ARG=$userMessage" else it
        })
    }

    fun navigateToTaskDetail(taskId: String) {
        navHostController.navigate("$TASK_DETAIL_SCREEN/$taskId")
    }

    fun navigateToAddEditTask(title: Int, taskId: String?) {
        navHostController.navigate("$ADD_EDIT_TASK_SCREEN/$title".let {
            if(taskId != null) "$it?$TASK_ID_ARG=$taskId" else it
        })
    }
}