package com.example.litenote.feature_note.presentation.screens.add_edit_note

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.add_edit_note.components.SaveNoteButton
import com.example.litenote.feature_note.presentation.screens.add_edit_note.components.TopBar
import com.example.litenote.feature_note.presentation.screens.add_edit_note.components.TextBox
import com.example.litenote.feature_note.presentation.screens.add_edit_note.utils.TextType

@Composable
fun AddEditNoteScreen(
    modifier: Modifier = Modifier,
    viewModel: AddEditNoteScreenViewModel = hiltViewModel(),
    note: Note?,
    onSetContent: () -> Unit,
    onSaveNoteButtonClicked: () -> Unit,
    onBackButtonClicked: () -> Unit,
) {
    val title = viewModel.title
    val body = viewModel.body
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
                    if (viewModel.currentNote != null) {
                        viewModel.updateNote()
                    }
                    else {
                        viewModel.addNote()
                    }
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
        Column(
            modifier = Modifier
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextBox(
                textType = TextType.Title,
                value = title,
                onValueChange = {
                    viewModel.updateTitle(it)
                },
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                focusRequester = focusRequester
            )
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(
                        width = 100.dp,
                        height = 2.dp
                    )
                    .background(color = MaterialTheme.colorScheme.primary)
            )
            TextBox(
                textType = TextType.Body,
                value = body,
                onValueChange = {
                    viewModel.updateBody(it)
                },
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                )
            )
        }
    }
}