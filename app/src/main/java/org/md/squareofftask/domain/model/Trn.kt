package org.md.squareofftask.domain.model

data class Trn(
    val name: String,
    val slug: String,
    val img: String?,
    val status: Int
) {
    val year: String
        get() = slug.split("-").last()

    val dashesCount: Int
        get() = slug.toCharArray().count { it == '-' }

    override fun toString(): String {
        return "Trn(name='$name', slug='$slug', img=$img, status=$status, year='$year', dashesCount=$dashesCount)"
    }
}