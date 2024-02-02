package com.example.litenote.feature_note.presentation.screens.add_edit_note.components

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.ui.theme.LiteNoteThemeContent

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
                    horizontal = 4.dp,
                    vertical = 16.dp
                ),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TopBarAddNoteLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        TopBar(
            note = null,
            onBackButtonClicked = {}
        )
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TopBarEditNoteLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        TopBar(
            note = Note(id = 1, title = "Title", body = "Body", isFavourite = false),
            onBackButtonClicked = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TopBarAddNoteDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        TopBar(
            note = null,
            onBackButtonClicked = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TopBarEditNoteDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        TopBar(
            note = Note(id = 1, title = "Title", body = "Body", isFavourite = false),
            onBackButtonClicked = {}
        )
    }
}