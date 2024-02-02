package com.example.litenote.feature_note.presentation.screens.view_note

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.view_note.components.EditNoteButton
import com.example.litenote.feature_note.presentation.screens.view_note.components.TextDisplay
import com.example.litenote.feature_note.presentation.screens.view_note.components.TopBar
import com.example.litenote.feature_note.presentation.screens.view_note.utils.TextType
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun ViewNoteScreen(
    modifier: Modifier = Modifier,
    viewModel: ViewNoteScreenViewModel = hiltViewModel(),
    note: Note?,
    onSetContent: () -> Unit,
    onBackButtonClicked: () -> Unit,
    onEditButtonClicked: (note: Note) -> Unit,
    onDeleteButtonClicked: () -> Unit
) {
    ViewNoteScreenContent(
        note = note,
        currentNote = viewModel.currentNote,
        onGetNote = { viewModel.getNote(it) },
        onSetContent = onSetContent,
        onDeleteNote = { viewModel.deleteNote() },
        onBackButtonClicked = onBackButtonClicked,
        onEditButtonClicked = onEditButtonClicked,
        onDeleteButtonClicked = onDeleteButtonClicked
    )
}

@Composable
fun ViewNoteScreenContent(
    note: Note?,
    currentNote: Note?,
    onGetNote: (long: Long) -> Unit,
    onSetContent: () -> Unit,
    onDeleteNote: () -> Unit,
    onBackButtonClicked: () -> Unit,
    onEditButtonClicked: (note: Note) -> Unit,
    onDeleteButtonClicked: () -> Unit
) {
    LaunchedEffect(Unit) {
        if (note != null) {
            onGetNote(note.id)
            onSetContent()
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                onBackButtonClicked = onBackButtonClicked,
                onDeleteButtonClicked = {
                    if (currentNote != null) {
                        onDeleteNote()
                    }
                    onDeleteButtonClicked()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (currentNote != null) {
                        onEditButtonClicked(currentNote)
                    }
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
                EditNoteButton()
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (currentNote != null) {
                TextDisplay(
                    modifier = Modifier.padding(all = 16.dp),
                    textType = TextType.Title,
                    value = currentNote.title,
                )
            }
            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(
                        width = 100.dp,
                        height = 2.dp
                    )
                    .background(color = MaterialTheme.colorScheme.primary)
            )
            if (currentNote != null) {
                TextDisplay(
                    modifier = Modifier.padding(all = 16.dp),
                    textType = TextType.Body,
                    value = currentNote.body,
                )
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ViewNoteScreenContentLightThemePreview() {
    LiteNoteThemeContent(
        darkTheme = false
    ) {
        ViewNoteScreenContent(
            note = Note(id = 1, title = "Title", body = "Body", isFavourite = false),
            currentNote = Note(id = 1, title = "Title", body = "Body", isFavourite = false),
            onGetNote = {},
            onSetContent = {},
            onDeleteNote = {},
            onBackButtonClicked = {},
            onEditButtonClicked = {},
            onDeleteButtonClicked = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun ViewNoteScreenContentDarkThemePreview() {
    LiteNoteThemeContent(
        darkTheme = true
    ) {
        ViewNoteScreenContent(
            note = Note(id = 1, title = "Title", body = "Body", isFavourite = false),
            currentNote = Note(id = 1, title = "Title", body = "Body", isFavourite = false),
            onGetNote = {},
            onSetContent = {},
            onDeleteNote = {},
            onBackButtonClicked = {},
            onEditButtonClicked = {},
            onDeleteButtonClicked = {}
        )
    }
}