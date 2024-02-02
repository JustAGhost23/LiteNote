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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenote.R
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun NoSearchResult(
    modifier: Modifier = Modifier,
    query: String
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
            painter = painterResource(id = R.drawable.no_search_icon),
            contentDescription = "No results found",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
        )
        Text(
            modifier = Modifier.weight(1f, fill = false),
            text = "No Results for\n \"$query\"",
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun NoSearchResultLightThemePreview() {
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
                NoSearchResult(
                    modifier = Modifier.padding(bottom = 64.dp),
                    query = "Query"
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
fun NoSearchResultDarkThemePreview() {
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
                NoSearchResult(
                    modifier = Modifier.padding(bottom = 64.dp),
                    query = "Query"
                )
            }
        }
    }
}