package com.example.litenote.feature_note.presentation.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenote.R
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    themeState: Boolean,
    onThemeButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "LiteNote",
                modifier = modifier.padding(
                    all = 12.dp
                ),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
            )
            IconButton(
                onClick = onThemeButtonClicked,
                modifier = modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .padding(top = 4.dp)
            ) {
                Icon(
                    painter = if (themeState) painterResource(
                        id = R.drawable.light_mode_icon
                    ) else painterResource(
                        id = R.drawable.dark_mode_icon
                    ),
                    contentDescription = "Mode Toggle",
                    tint = MaterialTheme.colorScheme.onPrimary
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
fun TopBarLightPreview() {
    LiteNoteThemeContent(darkTheme = false) {
        TopBar(
            themeState = false,
            onThemeButtonClicked = {},
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TopBarDarkModePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        TopBar(
            themeState = true,
            onThemeButtonClicked = {},
        )
    }
}