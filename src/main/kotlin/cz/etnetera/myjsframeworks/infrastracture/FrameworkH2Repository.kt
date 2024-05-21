package cz.etnetera.myjsframeworks.infrastracture

import cz.etnetera.myjsframeworks.domain.exception.ConflictException
import cz.etnetera.myjsframeworks.domain.framework.Framework
import cz.etnetera.myjsframeworks.domain.framework.FrameworkRanking
import cz.etnetera.myjsframeworks.domain.framework.FrameworkRepository
import cz.etnetera.myjsframeworks.domain.framework.FrameworkVersion
import cz.etnetera.myjsframeworks.infrastracture.jpa.FrameworkEntity
import cz.etnetera.myjsframeworks.infrastracture.jpa.FrameworkJPARepository
import cz.etnetera.myjsframeworks.infrastracture.jpa.FrameworkVersionEntity
import cz.etnetera.myjsframeworks.infrastracture.jpa.FrameworkVersionJPARepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import java.util.*

@Component
@Primary
class FrameworkH2Repository(
    @Autowired private val repository: FrameworkJPARepository,
    @Autowired private val versionRepository: FrameworkVersionJPARepository,
    @PersistenceContext private val entityManager: EntityManager,
) : FrameworkRepository {
    override fun getAll(): List<Framework> {
        return repository.findAll().map {
            Framework(
                it.id,
                it.name,
                FrameworkRanking(it.ranking),
                it.versions?.map { ver -> FrameworkVersion(ver.version, ver.deprecationDate) },
            )
        }
    }

    override fun create(framework: Framework): Framework {
        val entity = FrameworkEntity(
            framework.id,
            framework.name,
            framework.ranking.stars,
            null,
        )

        try {
            repository.save(entity)
        } catch (e: Exception) { // TODO: should be more specific
            throw ConflictException("Framework with name ${framework.name} already exists")
        }

        val versions = framework.versions?.map { ver ->
            FrameworkVersionEntity(
                UUID.randomUUID(),
                ver.version,
                ver.deprecationDate,
                entity,
            )
        }
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

    override fun search(input: String): List<Framework> {
        val query = entityManager.criteriaBuilder.createQuery(FrameworkEntity::class.java)
        val root = query.from(FrameworkEntity::class.java)

        val namePredicate = entityManager.criteriaBuilder.like(root.get("name"), "%$input%")
        val versionPredicate = entityManager.criteriaBuilder.like(
            root.join<FrameworkEntity, FrameworkVersionEntity>("versions").get("version"),
            "%$input%"
        )

        query.select(root).where(entityManager.criteriaBuilder.or(namePredicate, versionPredicate))

        return entityManager.createQuery(query).resultList.map {
            Framework(
                it.id,
                it.name,
                FrameworkRanking(it.ranking),
                it.versions?.map { ver -> FrameworkVersion(ver.version, ver.deprecationDate) },
            )
        }
    }
}