package com.example.litenote.di.module

import com.example.litenote.feature_note.domain.repository.NoteRepository
import com.example.litenote.feature_note.domain.usecase.DeleteUseCase
import com.example.litenote.feature_note.domain.usecase.GetAllUseCase
import com.example.litenote.feature_note.domain.usecase.GetByIdUseCase
import com.example.litenote.feature_note.domain.usecase.InsertUseCase
import com.example.litenote.feature_note.domain.usecase.NoteUseCases
import com.example.litenote.feature_note.domain.usecase.UpdateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesNoteUseCases(noteRepository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            InsertUseCase(noteRepository),
            UpdateUseCase(noteRepository),
            DeleteUseCase(noteRepository),
            GetAllUseCase(noteRepository),
            GetByIdUseCase(noteRepository)
        )
    }

}