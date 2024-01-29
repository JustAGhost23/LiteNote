package com.example.litenote.di.module

import com.example.litenote.feature_note.data.repository.NoteRepositoryImpl
import com.example.litenote.feature_note.domain.repository.NoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providesNoteRepository(noteRepositoryImpl: NoteRepositoryImpl): NoteRepository

}