package com.example.litenote.feature_note.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.home.components.AddNoteButton
import com.example.litenote.feature_note.presentation.screens.home.components.EmptyListDisplay
import com.example.litenote.feature_note.presentation.screens.home.components.NoSearchResult
import com.example.litenote.feature_note.presentation.screens.home.components.NoteGrid
import com.example.litenote.feature_note.presentation.screens.home.components.SearchBar
import com.example.litenote.feature_note.presentation.screens.home.components.TopBar

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onAddNoteButtonClicked: () -> Unit,
    onViewNoteButtonClicked: (note: Note) -> Unit
) {
    var hideKeyboard by remember { mutableStateOf(false) }
    val notes = viewModel.notes.collectAsState()
    val searchQuery = viewModel.searchQuery

    Scaffold(
        topBar = {
            TopBar()
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
                .clickable { hideKeyboard = true }
        ) {
            SearchBar(
                modifier = Modifier.padding(top = 12.dp),
                searchContent = searchQuery,
                onSearchContentChange = { viewModel.updateSearchQuery(it) },
                hideKeyboard = hideKeyboard,
                onFocusClear = { hideKeyboard = false }
            )
            if (notes.value.isEmpty() && searchQuery.isEmpty()) {
                Box(contentAlignment = Alignment.Center) {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        item {
                            EmptyListDisplay(
                                modifier = Modifier.padding(bottom = 64.dp)
                            )
                        }
                    }
                }
            } else if (notes.value.isEmpty() && searchQuery.isNotEmpty()) {
                NoSearchResult(
                    modifier = Modifier.padding(bottom = 64.dp),
                    query = searchQuery,
                )
            }

            NoteGrid(
                modifier = Modifier.padding(top = 12.dp),
                notes = notes,
                onTap = {
                    onTap(it)
                }
            )
        }
    }
}