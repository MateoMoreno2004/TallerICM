package com.example.taller.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.taller.data.model.User
import com.example.taller.ui.components.UserListItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UserListScreen(users: List<User>, onUserClick: (User) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        stickyHeader {
            Text(
                text = "Total usuarios: ${users.size}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
            )
        }
        items(users) { user ->
            UserListItem(user = user, onClick = { onUserClick(user) })
        }
    }
}
