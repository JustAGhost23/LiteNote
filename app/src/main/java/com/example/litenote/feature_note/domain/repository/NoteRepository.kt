package com.example.litenote.feature_note.domain.repository

import com.example.litenote.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insert(note: Note)

    suspend fun update(note: Note)

    suspend fun delete(note: Note)

    fun getAllNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Long): Note?
}