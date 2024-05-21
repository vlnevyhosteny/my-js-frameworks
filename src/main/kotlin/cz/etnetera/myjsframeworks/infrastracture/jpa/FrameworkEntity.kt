package cz.etnetera.myjsframeworks.infrastracture.jpa

import jakarta.persistence.*
import java.util.UUID

@Entity(name = "framework")
data class FrameworkEntity (
    @Id
    val id: UUID,
    @Column(unique = true)
    val name: String,
    val ranking: Int,

    @OneToMany(mappedBy = "framework", fetch = FetchType.LAZY)
    var versions: List<FrameworkVersionEntity>? = mutableListOf()
)