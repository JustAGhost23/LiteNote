package com.example.litenote.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.litenote.domain.model.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun NoteDAO(): NoteDAO

    companion object {
        const val DATABASE_NAME = "note_database"
    }

}