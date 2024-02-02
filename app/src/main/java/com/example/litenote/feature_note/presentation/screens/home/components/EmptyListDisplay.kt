package com.example.litenote.feature_note.presentation.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenote.R
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun EmptyListDisplay(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.weight(1f, fill = false),
            painter = painterResource(id = R.drawable.empty_list_icon),
            contentDescription = "No notes found",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )
        Text(
            modifier = Modifier.weight(1f, fill = false),
            text = "Create new notes using the add button",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun EmptyListDisplayLightThemePreview() {
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
                EmptyListDisplay(
                    modifier = Modifier.padding(bottom = 64.dp),
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
fun EmptyListDisplayDarkThemePreview() {
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
                EmptyListDisplay(
                    modifier = Modifier.padding(bottom = 64.dp),
                )
            }
        }
    }
}