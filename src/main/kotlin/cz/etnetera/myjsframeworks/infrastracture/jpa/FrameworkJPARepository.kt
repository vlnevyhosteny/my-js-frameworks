package cz.etnetera.myjsframeworks.infrastracture.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FrameworkJPARepository : JpaRepository<FrameworkEntity, UUID>