package org.md.squareofftask.domain.repository

import org.md.squareofftask.domain.model.Trn

interface MainRepository {
    suspend fun getTrns(): List<Trn>
}