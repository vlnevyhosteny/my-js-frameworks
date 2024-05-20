package cz.etnetera.myjsframeworks.infrastracture

import cz.etnetera.myjsframeworks.domain.Framework
import cz.etnetera.myjsframeworks.domain.FrameworkRanking
import cz.etnetera.myjsframeworks.domain.FrameworkRepository
import cz.etnetera.myjsframeworks.domain.FrameworkVersion
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Component
@Primary
@Repository
class FrameworkInMemoryRepository : FrameworkRepository {
    private val frameworks = mutableListOf<Framework>(
        Framework(
            UUID.randomUUID(),
            "React",
            mutableListOf(FrameworkVersion("1.2.3", LocalDate.now())),
            FrameworkRanking(4)
        ),
    )

    override fun findAll(): List<Framework> {
        return frameworks
    }
}