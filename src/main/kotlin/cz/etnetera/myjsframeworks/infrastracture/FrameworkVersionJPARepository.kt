package cz.etnetera.myjsframeworks.infrastracture

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FrameworkVersionJPARepository : JpaRepository<FrameworkVersionEntity, UUID>