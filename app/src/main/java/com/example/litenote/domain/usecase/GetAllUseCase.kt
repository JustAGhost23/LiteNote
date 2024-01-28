package com.example.litenote.domain.usecase

import com.example.litenote.domain.model.Note
import com.example.litenote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetAllUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(): Flow<List<Note>> {
        return repository.getAllNotes()
    }
}