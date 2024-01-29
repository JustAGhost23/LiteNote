package com.example.litenote.feature_note.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _notes = MutableStateFlow(emptyList<Note>())
    val notes: StateFlow<List<Note>> = _notes

    var searchQuery: String by mutableStateOf("")

    init {
        viewModelScope.launch {
            noteUseCases.getAllUseCase().collect {
                _notes.value = it
            }
        }
    }

    fun updateSearchQuery(query: String) {
        searchQuery = query
        viewModelScope.launch {
            if (searchQuery.isNotBlank()) {
                noteUseCases.getAllUseCase().collect {
                    _notes.value = it.filter { note ->
                        note.title.lowercase().contains(searchQuery.lowercase())
                    }
                }
            } else {
                noteUseCases.getAllUseCase().collect {
                    _notes.value = it
                }
            }
        }
    }

}