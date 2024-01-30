package com.example.litenote.feature_note.presentation.screens.add_edit_note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.usecase.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteScreenViewModel @Inject constructor (
    private val useCases: NoteUseCases,
) : ViewModel() {

    var title: String by mutableStateOf("")
    var body: String by mutableStateOf("")
    var isFavourite: Boolean by mutableStateOf(false)
    var currentNote: Note? = null

    fun updateTitle(value: String) {
        title = value
    }

    fun updateBody(value: String) {
        body = value
    }

    fun updateIsFavourite(value: Boolean) {
        isFavourite = value
    }

    fun addNote() {
        val newNote = Note(
            title = title.ifBlank { "Title" },
            body = body.ifBlank { "Body" },
            isFavourite = isFavourite
        )
        viewModelScope.launch {
            useCases.insertUseCase(newNote)
        }
    }

    fun getNote(id: Long) {
        viewModelScope.launch {
            currentNote = useCases.getByIdUseCase(id)
            if (currentNote != null) {
                title = currentNote!!.title
                body = currentNote!!.body
                isFavourite = currentNote!!.isFavourite
            }
        }
    }

    fun updateNote() {
        val updatedNote = Note(
            id = currentNote!!.id,
            title = title,
            body = body,
            isFavourite = isFavourite
        )
        viewModelScope.launch {
            useCases.updateUseCase(updatedNote)
        }
    }

}