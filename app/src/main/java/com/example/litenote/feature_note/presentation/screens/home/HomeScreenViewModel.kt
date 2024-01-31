package com.example.litenote.feature_note.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.litenote.core.utils.PreferencesDataStoreUtil
import com.example.litenote.core.utils.PreferencesDataStoreUtil.Companion.IS_DARK_MODE_KEY
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val preferencesDataStoreUtil: PreferencesDataStoreUtil,
    private val noteUseCases: NoteUseCases
) : ViewModel() {
    private val _notes = MutableStateFlow(emptyList<Note>())
    val notes: StateFlow<List<Note>> = _notes

    var searchQuery: String by mutableStateOf("")

    private val _themeState = MutableStateFlow(false)
    val themeState: StateFlow<Boolean> = _themeState

    private val preferencesDataStore = preferencesDataStoreUtil.preferencesDataStore

    init {
        viewModelScope.launch {
            launch {
                noteUseCases.getAllUseCase().collect {
                    _notes.value = it
                }
            }
            launch {
                preferencesDataStore.data.map {
                    it[IS_DARK_MODE_KEY] ?: false
                }.collect {
                    _themeState.value = it
                }
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

    fun toggleFavouriteStatus(note: Note) {
        val updatedNote = note.copy(isFavourite = !note.isFavourite)
        viewModelScope.launch {
            noteUseCases.updateUseCase(updatedNote)
        }
    }

    fun setTheme(isDarkTheme: Boolean) {
        viewModelScope.launch {
            preferencesDataStore.edit { preferences ->
                preferences[IS_DARK_MODE_KEY] = isDarkTheme
            }
        }
    }

    fun toggleTheme() {
        viewModelScope.launch {
            preferencesDataStore.edit { preferences ->
                preferences[IS_DARK_MODE_KEY] = !(preferences[IS_DARK_MODE_KEY] ?: false)
            }
        }
    }

}