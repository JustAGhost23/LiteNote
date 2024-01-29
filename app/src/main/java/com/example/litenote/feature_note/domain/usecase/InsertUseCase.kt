package com.example.litenote.feature_note.domain.usecase

import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.repository.NoteRepository

class InsertUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        return repository.insert(note)
    }
}