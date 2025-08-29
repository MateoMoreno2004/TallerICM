package com.example.taller.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller.data.model.User
import com.example.taller.ui.components.LabeledValue

@Composable
fun UserDetailScreen(user: User) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(model = user.image, contentDescription = "Foto ${user.name}", modifier = Modifier.size(180.dp))
        Spacer(Modifier.height(12.dp))
        Text(
            "${user.name} ${user.lastName}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(12.dp))

        LabeledValue("Empresa", user.company.name)

        Row(
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Teléfono", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
            Spacer(Modifier.width(8.dp))
            Text(
                user.phone,
                style = MaterialTheme.typography.bodyMedium,
                textDecoration = TextDecoration.Underline,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${user.phone}"))
                    context.startActivity(intent)
                }
            )
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${user.phone}"))
                context.startActivity(intent)
            }
        ) { Text("Llamar") }

        Spacer(Modifier.height(8.dp))
        LabeledValue("Email", user.email)
        LabeledValue("Edad", user.age.toString())
        LabeledValue("Género", user.gender)
        LabeledValue("Altura", user.height?.toString() ?: "N/D")
        LabeledValue("Peso", user.weight?.toString() ?: "N/D")
        LabeledValue("Universidad", user.university ?: "N/D")
    }
}



