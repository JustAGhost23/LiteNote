package com.example.litenote.feature_note.presentation.screens.home

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val notes = viewModel.notes.collectAsState()
    val searchQuery = viewModel.searchQuery

    Scaffold(
        topBar = {
            Text("LiteNote")
        }
    ) { paddingValues ->

    }
}