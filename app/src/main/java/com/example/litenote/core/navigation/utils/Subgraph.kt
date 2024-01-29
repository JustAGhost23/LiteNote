package com.example.litenote.core.navigation.utils

sealed class Subgraph(val route: String) {
    data object NoteFeature: Subgraph("note")
}