package org.md.squareofftask.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConfigDto(
    @SerialName("trns")
    val trns: List<TrnDto>
)