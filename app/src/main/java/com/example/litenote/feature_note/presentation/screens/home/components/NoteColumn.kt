package com.example.litenote.feature_note.presentation.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.litenote.feature_note.domain.model.Note

@Composable
fun NoteColumn(
    modifier: Modifier = Modifier,
    notes: State<List<Note>>,
    onTap: (note: Note) -> Unit,
    onIconButtonClick: (note: Note) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(notes.value, key = { note -> note.id }) { note ->
            NoteItem(
                note = note,
                onTap = { onTap(note) },
                onIconButtonClick = { onIconButtonClick(note) }
            )
        }
    }
}