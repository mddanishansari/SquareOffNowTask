package org.md.squareofftask.data.repository

import org.md.squareofftask.data.remote.ChessApi
import org.md.squareofftask.data.remote.dto.toTrns
import org.md.squareofftask.domain.model.Trn
import org.md.squareofftask.domain.repository.MainRepository

class MainRepositoryImpl(private val chessApi: ChessApi) : MainRepository {
    override suspend fun getTrns(): List<Trn> {
        return chessApi.getConfig().trns.toTrns()
    }
}