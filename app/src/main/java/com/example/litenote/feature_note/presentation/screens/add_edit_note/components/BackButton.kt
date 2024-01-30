package com.example.litenote.feature_note.presentation.screens.add_edit_note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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