package com.example.litenote.feature_note.domain.usecase

import com.example.litenote.feature_note.domain.model.Note
import com.example.litenote.feature_note.domain.repository.NoteRepository

class GetByIdUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Long): Note? {
        return repository.getNoteById(id)
    }
}