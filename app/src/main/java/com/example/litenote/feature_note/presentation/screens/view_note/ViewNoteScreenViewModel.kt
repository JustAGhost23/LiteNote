package com.example.litenote.feature_note.presentation.screens.view_note

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewNoteScreenViewModel @Inject constructor (
    private val noteUseCases: NoteUseCases,
) : ViewModel() {

    var currentNote: Note? = null

    fun getNote(id: Long) {
        viewModelScope.launch {
            currentNote = noteUseCases.getByIdUseCase(id)
        }
    }

}