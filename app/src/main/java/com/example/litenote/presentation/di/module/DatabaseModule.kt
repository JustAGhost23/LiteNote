package com.example.litenote.presentation.di.module

import android.content.Context
import androidx.room.Room
import com.example.litenote.data.datasource.db.NoteDAO
import com.example.litenote.data.datasource.db.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesNoteDAO(db: NoteDatabase): NoteDAO {
        return db.NoteDAO()
    }

}