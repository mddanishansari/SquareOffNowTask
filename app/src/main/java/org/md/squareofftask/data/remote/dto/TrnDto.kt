package org.md.squareofftask.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.md.squareofftask.domain.model.Trn

@Serializable
data class TrnDto(
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("img")
    val img: String?,
    @SerialName("status")
    val status: Int
) {
    constructor(name: String, slug: String, status: Int) : this(name, slug, null, status)
}

fun TrnDto.toTrn(): Trn {
    return Trn(name, slug, img, status)
}

fun List<TrnDto>.toTrns(): List<Trn> {
    return map { it.toTrn() }
}