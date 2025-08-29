package com.example.taller.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.taller.ui.components.SimpleCenteredText
import com.example.taller.ui.screens.UserDetailScreen
import com.example.taller.ui.screens.UsersListScreen
import com.example.taller.ui.viewmodel.UsersViewModel

@Composable
fun AppNavHost() {
    val nav = rememberNavController()
    val vm: UsersViewModel = viewModel()

    NavHost(navController = nav, startDestination = "list") {
        composable("list") {
            val state = vm.state.collectAsState()
            UsersListScreen(
                users = state.value.users,
                loading = state.value.loading
            ) { user ->
                nav.navigate("detail/${user.id}")
            }
        }
        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStack ->
            val id = backStack.arguments?.getInt("id") ?: return@composable
            val user = vm.userById(id)
            if (user != null) UserDetailScreen(user) else SimpleCenteredText("Cargando…")
        }
    }
}
