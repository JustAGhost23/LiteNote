package com.example.litenote.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.litenote.core.navigation.utils.Subgraph
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
            }

            composable(route = NoteScreens.AddEditNoteScreen.route) {
            }
        }
    }
}