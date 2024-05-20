package cz.etnetera.myjsframeworks.infrastracture

import cz.etnetera.myjsframeworks.domain.FrameworkVersion
import jakarta.persistence.*
import java.util.UUID

@Entity(name = "framework")
data class FrameworkEntity (
    @Id
    val id: UUID,
    val name: String,
    val ranking: Int,

    @OneToMany(mappedBy = "framework", fetch = FetchType.LAZY)
    var versions: List<FrameworkVersionEntity>? = mutableListOf()
)