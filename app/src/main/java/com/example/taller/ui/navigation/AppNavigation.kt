package com.example.taller.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taller.ui.screens.UserDetailScreen
import com.example.taller.ui.screens.UserListScreen
import com.example.taller.data.model.User

sealed class Screen(val route: String) {
    object UserList : Screen("user_list")
    object UserDetail : Screen("user_detail/{userId}") {
        fun createRoute(userId: Int) = "user_detail/$userId"
    }
}

@Composable
fun AppNavigation(navController: NavHostController, users: List<User>) {
    NavHost(navController = navController, startDestination = Screen.UserList.route) {
        composable(Screen.UserList.route) {
            UserListScreen(users = users, onUserClick = { user ->
                navController.navigate(Screen.UserDetail.createRoute(user.id))
            })
        }
        composable(Screen.UserDetail.route) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId")?.toIntOrNull()
            val user = users.find { it.id == userId }
            user?.let { UserDetailScreen(user = it) }
        }
    }
}
