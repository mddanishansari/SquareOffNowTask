package org.md.squareofftask.di

import org.md.squareofftask.data.remote.ChessApiClient
import org.md.squareofftask.data.repository.MainRepositoryImpl
import org.md.squareofftask.domain.repository.MainRepository

object AppModule {
    val mainRepository: MainRepository by lazy {
        MainRepositoryImpl(ChessApiClient.chessApi)
    }
}