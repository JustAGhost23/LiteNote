package com.example.litenote.feature_note.presentation.screens.view_note

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.domain.model.Note

@Composable
fun ViewNoteScreen(
    viewModel: ViewNoteScreenViewModel = hiltViewModel(),
    note: Note?,
    onSetContent: () -> Unit,
    onBackButtonClicked: () -> Unit,
    onEditButtonClicked: (note: Note) -> Unit,
    onDeleteButtonClicked: () -> Unit
) {
    LaunchedEffect(Unit) {
        if (note != null) {
            viewModel.getNote(note.id)
            onSetContent()
        }
    }
}