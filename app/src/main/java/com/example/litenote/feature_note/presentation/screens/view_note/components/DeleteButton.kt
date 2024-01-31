package com.example.litenote.feature_note.presentation.screens.view_note.components

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