package com.example.taller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.taller.data.model.User
import com.example.taller.data.remote.ApiClient
import com.example.taller.ui.navigation.AppNavigation
import com.example.taller.ui.theme.TallerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    var users by remember { mutableStateOf<List<User>>(emptyList()) }
                    val scope = rememberCoroutineScope()

                    LaunchedEffect(Unit) {
                        scope.launch {
                            users = ApiClient.getUsers().users
                        }
                    }

                    if (users.isNotEmpty()) {
                        AppNavigation(navController, users)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    TallerTheme {
        val sampleUsers = listOf(
            User(
                id = 1,
                firstName = "Mateo",
                lastName = "Martínez",
                phone = "123456789",
                email = "mateo@example.com",
                age = 25,
                gender = "male",
                birthDate = "1998-01-01",
                height = 1.80,
                weight = 75.0,
                image = "https://robohash.org/mateo.png",
                company = com.example.taller.data.model.Company("OpenAI")
            )
        )
        val navController = rememberNavController()
        AppNavigation(navController, sampleUsers)
    }
}
