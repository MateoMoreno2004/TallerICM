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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.taller.data.model.User
import com.example.taller.ui.components.LabeledValue
import com.example.taller.R

@Composable
fun UserDetailScreen(user: User) {
    val context = LocalContext.current
    val notAvailable = stringResource(R.string.not_available)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = user.image,
            contentDescription = stringResource(R.string.user_photo_content_desc, user.name),
            modifier = Modifier.size(180.dp)
        )
        Spacer(Modifier.height(12.dp))
        Text(
            "${user.name} ${user.lastName}",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(12.dp))

        LabeledValue(stringResource(R.string.company_label), user.company.name)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stringResource(R.string.phone_label),
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
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

        Spacer(Modifier.height(8.dp))
        LabeledValue(stringResource(R.string.email_label), user.email)
        LabeledValue(stringResource(R.string.age_label), user.age.toString())
        LabeledValue(stringResource(R.string.gender_label), user.gender)
        LabeledValue(stringResource(R.string.height_label), user.height?.toString() ?: notAvailable)
        LabeledValue(stringResource(R.string.weight_label), user.weight?.toString() ?: notAvailable)
        LabeledValue(stringResource(R.string.university_label), user.university ?: notAvailable)
    }
}



