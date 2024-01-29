package com.example.litenote.feature_note.domain.usecase

import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(): Flow<List<Note>> {
        return repository.getAllNotes()
    }
}