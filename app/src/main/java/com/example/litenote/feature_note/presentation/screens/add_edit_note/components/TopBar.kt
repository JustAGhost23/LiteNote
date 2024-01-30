package com.example.litenote.feature_note.presentation.screens.add_edit_note.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.litenote.feature_note.domain.model.Note

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    note: Note?,
    onBackButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            BackButton(
                modifier = Modifier.padding(
                    horizontal = 6.dp,
                    vertical = 8.dp
                ),
                onButtonClick = onBackButtonClicked
            )
            Text(
                text = if (note != null) "Update Note" else "Add Note",
                modifier = modifier.padding(
                    all = 12.dp
                ),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}