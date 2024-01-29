package com.example.litenote.feature_note.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.litenote.feature_note.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun NoteDAO(): NoteDAO

    companion object {
        const val DATABASE_NAME = "note_database"
    }

}