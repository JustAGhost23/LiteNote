package com.example.litenote.feature_note.presentation.util

sealed class NoteScreens(val route: String) {
    data object HomeScreen : NoteScreens("home_screen")
    data object AddEditNoteScreen : NoteScreens("add_edit_note_screen")
    data object ViewNoteScreen : NoteScreens("view_note_screen")
}