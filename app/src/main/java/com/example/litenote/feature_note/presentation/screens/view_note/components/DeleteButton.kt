package com.example.litenote.feature_note.presentation.screens.view_note.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun DeleteButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    val showDialog = remember { mutableStateOf(false) }

    if (showDialog.value) {
        DeleteAlertDialog(
            showDialog = showDialog.value,
            onDismiss = {
                showDialog.value = false
            },
            onConfirm = {
                showDialog.value = false
                onButtonClick()
            })
    }

    IconButton(
        onClick = {
            showDialog.value = true
        },
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = "Delete",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun DeleteButtonLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        DeleteButton(
            onButtonClick = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DeleteButtonDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        DeleteButton(
            onButtonClick = {}
        )
    }
}