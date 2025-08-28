package com.example.taller.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller.R
import com.example.taller.data.model.User

@Composable
fun UserDetailScreen(user: User) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        AsyncImage(
            model = user.image,
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .padding(bottom = 16.dp)
        )
        Text(text = "${user.firstName} ${user.lastName}", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = stringResource(R.string.email_label, user.email))
        Text(
            text = stringResource(R.string.phone_label, user.phone),
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.clickable {
                val intent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:${user.phone}")
                }
                context.startActivity(intent)
            }
        )
        Text(text = stringResource(R.string.age_label, user.age))
        Text(text = stringResource(R.string.gender_label, user.gender))
        Text(text = stringResource(R.string.birth_label, user.birthDate))
        Text(text = stringResource(R.string.height_label, user.height))
        Text(text = stringResource(R.string.weight_label, user.weight))
    }
}

