package com.example.litenote.feature_note.presentation.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun NoteColumn(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onTap: (note: Note) -> Unit,
    onIconButtonClick: (note: Note) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(notes, key = { note -> note.id }) { note ->
            NoteItem(
                note = note,
                onTap = { onTap(note) },
                onIconButtonClick = { onIconButtonClick(note) }
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun NoteColumnLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .clickable(
                        onClick = {},
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    )
            ) {
                NoteColumn(
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
                    notes = listOf(
                        Note(
                            id = 1,
                            title = "Title 1",
                            body = "Body 1",
                            isFavourite = true
                        ),
                        Note(
                            id = 2,
                            title = "Title 2",
                            body = "Body 2",
                            isFavourite = true
                        ),
                        Note(
                            id = 3,
                            title = "Title 3",
                            body = "Body 3",
                            isFavourite = false
                        ),
                        Note(
                            id = 4,
                            title = "Title 4",
                            body = "Body 4",
                            isFavourite = false
                        )
                    ),
                    onTap = {},
                    onIconButtonClick = {}
                )
            }
        }
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun NoteColumnDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(paddingValues)
                    .clickable(
                        onClick = {},
                        indication = null,
                        interactionSource = MutableInteractionSource()
                    )
            ) {
                NoteColumn(
                    modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
                    notes = listOf(
                        Note(
                            id = 1,
                            title = "Title 1",
                            body = "Body 1",
                            isFavourite = true
                        ),
                        Note(
                            id = 2,
                            title = "Title 2",
                            body = "Body 2",
                            isFavourite = true
                        ),
                        Note(
                            id = 3,
                            title = "Title 3",
                            body = "Body 3",
                            isFavourite = false
                        ),
                        Note(
                            id = 4,
                            title = "Title 4",
                            body = "Body 4",
                            isFavourite = false
                        )
                    ),
                    onTap = {},
                    onIconButtonClick = {}
                )
            }
        }
    }
}