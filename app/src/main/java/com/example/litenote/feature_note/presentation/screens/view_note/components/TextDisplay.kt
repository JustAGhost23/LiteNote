package com.example.litenote.feature_note.presentation.screens.view_note.components

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.litenote.feature_note.presentation.screens.view_note.utils.TextType
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun TextDisplay(
    modifier: Modifier = Modifier,
    textType: TextType,
    value: String,
) {
    Text(
        modifier = modifier,
        text = value,
        color = MaterialTheme.colorScheme.onBackground,
        style = if (textType == TextType.Title) {
            MaterialTheme.typography.titleMedium
        } else {
            MaterialTheme.typography.titleSmall
        },
        minLines = 1,
    )
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TextBoxTitleTypeLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        TextDisplay(
            textType = TextType.Title,
            value = "Title",
        )
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TextBoxBodyTypeLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        TextDisplay(
            textType = TextType.Body,
            value = "Body",
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TextBoxTitleTypeDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        TextDisplay(
            textType = TextType.Title,
            value = "Title",
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TextBoxBodyTypeDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        TextDisplay(
            textType = TextType.Body,
            value = "Body",
        )
    }
}