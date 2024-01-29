package com.example.litenote.core.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.litenote.core.navigation.utils.Subgraph
import com.example.litenote.feature_note.presentation.screens.home.HomeScreen
import com.example.litenote.feature_note.presentation.screens.home.HomeScreenViewModel
import com.example.litenote.feature_note.presentation.util.NoteScreens

@Composable
fun Navigation(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Subgraph.NoteFeature.route
    ) {
        navigation(
            startDestination = NoteScreens.HomeScreen.route,
            route = Subgraph.NoteFeature.route
        ) {
            composable(route = NoteScreens.HomeScreen.route) {
                val viewModel = hiltViewModel<HomeScreenViewModel>()
                HomeScreen(
                    viewModel = viewModel,
                    onAddNoteButtonClicked = { navHostController.navigate(NoteScreens.AddEditNoteScreen.route) })
            }

            composable(route = NoteScreens.AddEditNoteScreen.route) {
            }

            composable(route = NoteScreens.ViewNoteScreen.route) {
            }
        }
    }
}