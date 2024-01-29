package com.example.litenote.feature_note.presentation.screens.home

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.presentation.screens.home.components.AddNoteButton

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onAddNoteButtonClicked: () -> Unit,
) {
    val notes = viewModel.notes.collectAsState()
    val searchQuery = viewModel.searchQuery

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteButtonClicked,
                shape = RoundedCornerShape(4.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                    hoveredElevation = 0.dp
                ),
            ) {
                AddNoteButton()
            }
        }
    ) { paddingValues ->

    }
}