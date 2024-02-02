package com.example.litenote.feature_note.presentation.screens.home

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.home.components.AddNoteButton
import com.example.litenote.feature_note.presentation.screens.home.components.EmptyListDisplay
import com.example.litenote.feature_note.presentation.screens.home.components.NoSearchResult
import com.example.litenote.feature_note.presentation.screens.home.components.NoteColumn
import com.example.litenote.feature_note.presentation.screens.home.components.SearchBar
import com.example.litenote.feature_note.presentation.screens.home.components.TopBar
import com.example.litenote.ui.theme.LiteNoteTheme
import com.example.litenote.ui.theme.LiteNoteThemeContent

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onAddNoteButtonClicked: () -> Unit,
    onViewNoteButtonClicked: (note: Note) -> Unit
) {
    var hideKeyboard by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val notes = viewModel.notes.collectAsState()
    val themeState = viewModel.themeState.collectAsState()
    val searchQuery = viewModel.searchQuery
    val isDarkTheme = isSystemInDarkTheme()

    HomeScreenContent(
        hideKeyboard = hideKeyboard,
        interactionSource = interactionSource,
        notes = notes.value,
        themeState = themeState.value,
        searchQuery = searchQuery,
        isDarkTheme = isDarkTheme,
        onSetTheme = { viewModel.setTheme(isDarkTheme) },
        onHideKeyboard = { hideKeyboard = true },
        onDisplayKeyboard = { hideKeyboard = false },
        onToggleTheme = { viewModel.toggleTheme() },
        onAddNoteButtonClicked = onAddNoteButtonClicked,
        onViewNoteButtonClicked = onViewNoteButtonClicked,
        onSearchContentChange = { viewModel.updateSearchQuery(it) },
        onToggleFavouriteStatus = { viewModel.toggleFavouriteStatus(it) }
    )
}

@Composable
fun HomeScreenContent(
    hideKeyboard: Boolean,
    interactionSource: MutableInteractionSource,
    notes: List<Note>,
    themeState: Boolean,
    searchQuery: String,
    isDarkTheme: Boolean,
    onSetTheme: (isDarkTheme: Boolean) -> Unit,
    onHideKeyboard: () -> Unit,
    onDisplayKeyboard: () -> Unit,
    onToggleTheme: () -> Unit,
    onAddNoteButtonClicked: () -> Unit,
    onViewNoteButtonClicked: (note: Note) -> Unit,
    onSearchContentChange: (string: String) -> Unit,
    onToggleFavouriteStatus: (note: Note) -> Unit
) {
    LaunchedEffect(Unit) {
        onSetTheme(isDarkTheme)
    }

    Scaffold(
        topBar = {
            TopBar(
                themeState = themeState,
                onThemeButtonClicked = onToggleTheme
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddNoteButtonClicked,
                shape = RoundedCornerShape(4.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                    hoveredElevation = 0.dp
                ),
            ) {
                AddNoteButton()
            }
        }
    ) { paddingValues ->
        fun onTap(note: Note) {
            onViewNoteButtonClicked(note)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .clickable(
                    onClick = onHideKeyboard,
                    indication = null,
                    interactionSource = interactionSource
                )
        ) {
            SearchBar(
                modifier = Modifier.padding(top = 12.dp),
                searchContent = searchQuery,
                onSearchContentChange = onSearchContentChange,
                hideKeyboard = hideKeyboard,
                onFocusClear = onDisplayKeyboard
            )
            if (notes.isEmpty() && searchQuery.isEmpty()) {
                EmptyListDisplay(
                    modifier = Modifier.padding(bottom = 64.dp)
                )
            } else if (notes.isEmpty() && searchQuery.isNotEmpty()) {
                NoSearchResult(
                    modifier = Modifier.padding(bottom = 64.dp),
                    query = searchQuery,
                )
            }
            NoteColumn(
                modifier = Modifier.padding(top = 12.dp),
                notes = notes,
                onTap = {
                    onTap(it)
                },
                onIconButtonClick = onToggleFavouriteStatus
            )
        }
    }
}

@Preview(
    name = "Light Mode",
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun HomeScreenContentLightThemePreview() {
    LiteNoteThemeContent(
        darkTheme = false,
    ) {
        HomeScreenContent(
            hideKeyboard = false,
            interactionSource = MutableInteractionSource(),
            notes = listOf(),
            themeState = false,
            searchQuery = "",
            isDarkTheme = false,
            onSetTheme = {},
            onHideKeyboard = {},
            onDisplayKeyboard = {},
            onToggleTheme = {},
            onAddNoteButtonClicked = {},
            onViewNoteButtonClicked = {},
            onSearchContentChange = {},
            onToggleFavouriteStatus = {}
        )
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenContentDarkThemePreview() {
    LiteNoteThemeContent(
        darkTheme = true,
    ) {
        HomeScreenContent(
            hideKeyboard = false,
            interactionSource = MutableInteractionSource(),
            notes = listOf(),
            themeState = false,
            searchQuery = "",
            isDarkTheme = false,
            onSetTheme = {},
            onHideKeyboard = {},
            onDisplayKeyboard = {},
            onToggleTheme = {},
            onAddNoteButtonClicked = {},
            onViewNoteButtonClicked = {},
            onSearchContentChange = {},
            onToggleFavouriteStatus = {}
        )
    }
}