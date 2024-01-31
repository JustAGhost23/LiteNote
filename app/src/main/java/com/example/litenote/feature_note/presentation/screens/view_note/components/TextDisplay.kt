package com.example.litenote.feature_note.presentation.screens.view_note.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.litenote.feature_note.presentation.screens.view_note.utils.TextType

@Composable
fun TextDisplay(
    modifier: Modifier = Modifier,
    textType: TextType,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        color = MaterialTheme.colorScheme.onBackground,
        style = if (textType == TextType.Title) {
            MaterialTheme.typography.titleMedium
        } else {
            MaterialTheme.typography.titleSmall
        },
        minLines = 1,
    )
}