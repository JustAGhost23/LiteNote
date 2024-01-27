package com.example.litenote.data.repository

import com.example.litenote.data.datasource.db.NoteDAO
import com.example.litenote.domain.model.Note
import com.example.litenote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDAO
) : NoteRepository {
    override suspend fun insert(note: Note) {
        return dao.insert(note)
    }

    override suspend fun update(note: Note) {
        return dao.update(note)
    }

    override suspend fun delete(note: Note) {
        return dao.delete(note)
    }

    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
    }

    override suspend fun getNoteById(id: Long): Note? {
        return dao.getNoteById(id)
    }
}