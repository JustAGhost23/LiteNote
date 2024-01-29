package com.example.litenote.feature_note.domain.usecase

data class NoteUseCases (
    val insertUseCase: InsertUseCase,
    val updateUseCase: UpdateUseCase,
    val deleteUseCase: DeleteUseCase,
    val getAllUseCase: GetAllUseCase,
    val getByIdUseCase: GetByIdUseCase
)