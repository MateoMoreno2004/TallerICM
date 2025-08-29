package com.example.taller.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taller.data.model.User
import com.example.taller.ui.components.UserListItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UsersListScreen(
    users: List<User>,
    loading: Boolean,
    onUserClick: (User) -> Unit
) {
    if (loading) {
        androidx.compose.foundation.layout.Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = androidx.compose.ui.Alignment.Center
        ) { CircularProgressIndicator() }
        return
    }

    LazyColumn(Modifier.fillMaxSize()) {
        stickyHeader {
            Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)) {
                Text(
                    text = "Total usuarios: ${users.size}",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        items(users, key = { it.id }) { u ->
            UserListItem(user = u) { onUserClick(u) }
        }
    }
}

