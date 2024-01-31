package com.example.litenote.feature_note.presentation.screens.view_note.components

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

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onBackButtonClicked: () -> Unit,
    onDeleteButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
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
                    text = "LiteNote",
                    modifier = modifier.padding(
                        horizontal = 4.dp,
                        vertical = 16.dp
                    ),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontWeight = FontWeight.Bold,
                )
            }
            DeleteButton(
                modifier = Modifier.padding(
                    horizontal = 6.dp,
                    vertical = 8.dp
                ),
                onButtonClick = onDeleteButtonClicked
            )
        }
    }
}