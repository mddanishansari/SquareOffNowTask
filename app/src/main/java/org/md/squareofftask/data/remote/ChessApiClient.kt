package org.md.squareofftask.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ChessApiClient {
    private val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }

    val chessApi: ChessApi by lazy {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(ChessApi::class.java)
    }

    private const val BASE_URL = "https://followchess.com/"
}