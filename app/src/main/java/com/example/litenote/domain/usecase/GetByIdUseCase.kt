package com.example.litenote.domain.usecase

import com.example.litenote.domain.model.Note
import com.example.litenote.domain.repository.NoteRepository

class GetByIdUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Long): Note? {
        return repository.getNoteById(id)
    }
}