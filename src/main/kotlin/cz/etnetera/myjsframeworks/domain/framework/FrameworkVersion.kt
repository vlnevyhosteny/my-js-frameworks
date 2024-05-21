package cz.etnetera.myjsframeworks.domain.framework

import java.time.LocalDate

data class FrameworkVersion (
    val version: String,
    val deprecationDate: LocalDate,
)