package com.example.litenote.feature_note.presentation.screens.view_note.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit
) {
    IconButton(
        onClick = onButtonClick,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "Go Back",
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun BackButtonLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        BackButton(
            onButtonClick = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun BackButtonDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        BackButton(
            onButtonClick = {}
        )
    }
}