package cz.etnetera.myjsframeworks.domain

import java.util.UUID

data class Framework(val id: UUID, val name: String, val versions: List<FrameworkVersion>, val ranking: FrameworkRanking) {
    fun validate() {
        if (name.isBlank()) {
            throw DomainException("Name must not be blank")
        }
        ranking.validate()
    }
}
