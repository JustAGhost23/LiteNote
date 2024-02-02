package com.example.litenote.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.litenote.core.navigation.utils.Subgraph
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.presentation.screens.add_edit_note.AddEditNoteScreen
import com.example.litenote.feature_note.presentation.screens.home.HomeScreen
import com.example.litenote.feature_note.presentation.screens.view_note.ViewNoteScreen
import com.example.litenote.feature_note.presentation.utils.NoteScreens

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
            var note: Note? = null
            composable(route = NoteScreens.HomeScreen.route) {
                HomeScreen(
                    onAddNoteButtonClicked = { navHostController.navigate(NoteScreens.AddEditNoteScreen.route) },
                    onViewNoteButtonClicked = {
                        note = it
                        navHostController.navigate(NoteScreens.ViewNoteScreen.route)
                    })
            }

            composable(route = NoteScreens.AddEditNoteScreen.route) {
                AddEditNoteScreen(
                    note = note,
                    onSetContent = { note = null },
                    onSaveNoteButtonClicked = {
                        navHostController.navigate(NoteScreens.HomeScreen.route) {
                            popUpTo(NoteScreens.HomeScreen.route) {
                                inclusive = true
                            }
                        }
                    },
                    onBackButtonClicked = { navHostController.navigateUp() }
                )
            }

            composable(route = NoteScreens.ViewNoteScreen.route) {
                ViewNoteScreen(
                    note = note,
                    onSetContent = { note = null },
                    onBackButtonClicked = { navHostController.navigateUp() },
                    onEditButtonClicked = {
                        note = it
                        navHostController.navigate(NoteScreens.AddEditNoteScreen.route)
                    },
                    onDeleteButtonClicked = { navHostController.navigateUp() }
                )
            }
        }
    }
}