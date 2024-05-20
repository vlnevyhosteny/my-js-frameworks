package cz.etnetera.myjsframeworks.domain

import java.time.LocalDate

data class FrameworkVersion (
    val version: String,
    val deprecationDate: LocalDate,
) {
    constructor(version: String, deprecationDate: String) : this(version, LocalDate.parse(deprecationDate))
}