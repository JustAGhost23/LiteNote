package com.example.litenote.feature_note.presentation.screens.add_edit_note

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.add_edit_note.components.SaveNoteButton
import com.example.litenote.feature_note.presentation.screens.add_edit_note.components.TopBar

@Composable
fun AddEditNoteScreen(
    modifier: Modifier = Modifier,
    viewModel: AddEditNoteScreenViewModel,
    note: Note?,
    onSetContent: () -> Unit,
    onSaveNoteButtonClicked: () -> Unit,
    onBackButtonClicked: () -> Unit,
) {
    val title = viewModel.title
    val body = viewModel.body
    val isFavourite = viewModel.isFavourite
    val focusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        if (note != null) {
            viewModel.getNote(note.id)
            onSetContent()
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                note = viewModel.currentNote,
                onBackButtonClicked = onBackButtonClicked
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (viewModel.currentNote != null)
                        viewModel.updateNote()
                    else
                        viewModel.addNote()
                    onSaveNoteButtonClicked()
                },
                shape = RoundedCornerShape(4.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                    hoveredElevation = 0.dp
                ),
            ) {
                SaveNoteButton()
            }
        }
    ) { paddingValues ->

    }
}