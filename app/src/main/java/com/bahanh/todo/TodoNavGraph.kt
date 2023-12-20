package com.bahanh.todo

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavAction
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bahanh.todo.TodoDestinationsArgs.USER_MESSAGE_ARG
import kotlinx.coroutines.CoroutineScope


@Composable
fun TodoNavGraph(
    modifier: Modifier,
    navHostController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    startDestination: String = TodoDestinations.TASKS_ROUTE,
    navAction: TodoNavigationActions = remember(navHostController) {
        TodoNavigationActions(navHostController)
    }
) {
    val currentNavBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = currentNavBackStackEntry?.destination?.route ?: startDestination

    NavHost(
        navController = navHostController, startDestination = startDestination, modifier = modifier
    ) {
        composable(
            TodoDestinations.TASKS_ROUTE, arguments = listOf(navArgument(USER_MESSAGE_ARG) {
                type = NavType.IntType; defaultValue = 0
            })
        ) {
            entry -> 
        }
    }

}

const val ADD_EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 1
const val DELETE_RESULT_OK = Activity.RESULT_FIRST_USER + 2
const val EDIT_RESULT_OK = Activity.RESULT_FIRST_USER + 3