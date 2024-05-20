package cz.etnetera.myjsframeworks.domain

import java.util.UUID

data class Framework(val id: UUID, val name: String, val versions: List<FrameworkVersion>, val ranking: FrameworkRanking) {
}
