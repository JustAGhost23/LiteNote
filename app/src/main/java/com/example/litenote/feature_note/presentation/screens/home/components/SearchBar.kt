package com.example.litenote.feature_note.presentation.screens.home.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.litenote.R
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    searchContent: String,
    hideKeyboard: Boolean = false,
    onFocusClear: () -> Unit = {},
    onSearchContentChange: (String) -> Unit,
) {
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = searchContent,
            onValueChange = onSearchContentChange,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                focusManager.clearFocus()
                onSearchContentChange(searchContent)
            }),
            singleLine = true,
            maxLines = 1,
            placeholder = { Text(text = "Search") },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = "Search",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onBackground)
                )
            },
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                unfocusedSupportingTextColor = MaterialTheme.colorScheme.onBackground,
                focusedContainerColor = MaterialTheme.colorScheme.background,
                focusedIndicatorColor = MaterialTheme.colorScheme.onBackground,
                errorIndicatorColor = MaterialTheme.colorScheme.error,
                errorContainerColor = MaterialTheme.colorScheme.errorContainer,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            textStyle = MaterialTheme.typography.bodyLarge,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )

        if (hideKeyboard) {
            focusManager.clearFocus()
            onFocusClear()
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun SearchBarLightThemePreview() {
    LiteNoteThemeContent(darkTheme = false) {
        SearchBar(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
            searchContent = "",
            onSearchContentChange = {},
            hideKeyboard = false,
            onFocusClear = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun SearchBarDarkThemePreview() {
    LiteNoteThemeContent(darkTheme = true) {
        SearchBar(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 12.dp),
            searchContent = "",
            onSearchContentChange = {},
            hideKeyboard = false,
            onFocusClear = {}
        )
    }
}