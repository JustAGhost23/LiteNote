package com.example.litenote.feature_note.presentation.screens.view_note

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.view_note.components.EditNoteButton
import com.example.litenote.feature_note.presentation.screens.view_note.components.TextDisplay
import com.example.litenote.feature_note.presentation.screens.view_note.components.TopBar
import com.example.litenote.feature_note.presentation.screens.view_note.utils.TextType

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
    LaunchedEffect(Unit) {
        if (note != null) {
            viewModel.getNote(note.id)
            onSetContent()
        }
    }

    Scaffold(
        topBar = {
            TopBar(
                onBackButtonClicked = onBackButtonClicked,
                onDeleteButtonClicked = {
                    if (viewModel.currentNote != null) {
                        viewModel.deleteNote()
                    }
                    onDeleteButtonClicked()
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (viewModel.currentNote != null) {
                        onEditButtonClicked(viewModel.currentNote!!)
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
            if (viewModel.currentNote != null) {
                TextDisplay(
                    modifier = Modifier.padding(all = 16.dp),
                    textType = TextType.Title,
                    value = viewModel.currentNote!!.title,
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
            if (viewModel.currentNote != null) {
                TextDisplay(
                    modifier = Modifier.padding(all = 16.dp),
                    textType = TextType.Body,
                    value = viewModel.currentNote!!.body,
                )
            }
        }
    }
}