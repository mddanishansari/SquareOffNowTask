package org.md.squareofftask.data.remote

import org.md.squareofftask.data.remote.dto.ConfigDto
import retrofit2.http.GET

interface ChessApi {
    @GET("config.json")
    suspend fun getConfig(): ConfigDto
}