package com.example.litenote.domain.usecase

import com.example.litenote.domain.model.Note
import com.example.litenote.domain.repository.NoteRepository

class DeleteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        return repository.delete(note)
    }
}