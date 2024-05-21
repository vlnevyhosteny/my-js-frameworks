package cz.etnetera.myjsframeworks.application

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank

data class CreateFrameworkDTO(
    @field:NotBlank(message = "Name is required")
    val name: String,
    @field:Min(value = 1, message = "Stars must be between 1 and 5")
    @field:Max(value = 5, message = "Stars must be between 1 and 5")
    val ranking: Int
)