package com.example.taller.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller.data.model.User

@Composable
fun UserListItem(user: User, onClick: () -> Unit) {
    ListItem(
        headlineContent = { Text("${user.name} ${user.lastName}", fontWeight = FontWeight.SemiBold) },
        supportingContent = { Text(user.company.name) },
        leadingContent = {
            AsyncImage(model = user.image, contentDescription = "Foto ${user.name}", modifier = Modifier.size(46.dp))
        },
        trailingContent = { Icon(Icons.Filled.ChevronRight, contentDescription = null) },
        modifier = Modifier.clickable(onClick = onClick).fillMaxWidth()
    )
    Divider()
}

@Composable
fun LabeledValue(label: String, value: String) {
    Column(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
        Text(value, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun SimpleCenteredText(text: String) {
    androidx.compose.foundation.layout.Box(
        Modifier.fillMaxSize(),
        contentAlignment = androidx.compose.ui.Alignment.Center
    ) { Text(text) }
}

