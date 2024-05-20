package cz.etnetera.myjsframeworks.infrastracture

import cz.etnetera.myjsframeworks.domain.Framework
import cz.etnetera.myjsframeworks.domain.FrameworkRanking
import cz.etnetera.myjsframeworks.domain.FrameworkRepository
import cz.etnetera.myjsframeworks.domain.FrameworkVersion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.util.*

@Component
@Primary
class FrameworkH2Repository (
    @Autowired private val repository: FrameworkJPARepository,
    @Autowired private val versionRepository: FrameworkVersionJPARepository,
) : FrameworkRepository {
    override fun getAll(): List<Framework> {
        return repository.findAll().map { Framework(
            it.id,
            it.name,
            FrameworkRanking(it.ranking),
            it.versions?.map { ver -> FrameworkVersion(ver.version, ver.deprecationDate) },
            ) }
    }

    override fun create(framework: Framework): Framework {
        val entity = FrameworkEntity (
            framework.id,
            framework.name,
            framework.ranking.stars,
            null,
        )

        repository.save(entity)

        val versions = framework.versions?.map { ver -> FrameworkVersionEntity(
            UUID.randomUUID(),
            ver.version,
            ver.deprecationDate,
            entity,
        ) }
        if (versions != null) {
            versionRepository.saveAll(versions)
        }

        return Framework(
            framework.id,
            framework.name,
            FrameworkRanking(entity.ranking),
            framework.versions?.map { ver -> FrameworkVersion(ver.version, ver.deprecationDate) },
        )
    }
}