package com.example.taller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.taller.ui.theme.UsersAppTheme
import com.example.taller.ui.navigation.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UsersAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavHost()  // Navegación está en ui/NavGraph.kt
                }
            }
        }
    }
}

