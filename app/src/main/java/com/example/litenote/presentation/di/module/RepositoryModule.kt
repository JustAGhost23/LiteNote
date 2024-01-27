package com.example.litenote.presentation.di.module

import com.example.litenote.data.datasource.db.NoteDatabase
import com.example.litenote.data.repository.NoteRepositoryImpl
import com.example.litenote.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(dao = db.NoteDAO())
    }

}