package cz.etnetera.myjsframeworks.domain.framework

import java.util.UUID

data class Framework(val id: UUID, val name: String, val ranking: FrameworkRanking, val versions: List<FrameworkVersion>?) {
}
