package com.example.litenote.presentation.di.module

import com.example.litenote.domain.repository.NoteRepository
import com.example.litenote.domain.usecase.DeleteUseCase
import com.example.litenote.domain.usecase.GetAllUseCase
import com.example.litenote.domain.usecase.GetByIdUseCase
import com.example.litenote.domain.usecase.InsertUseCase
import com.example.litenote.domain.usecase.NoteUseCases
import com.example.litenote.domain.usecase.UpdateUseCase
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