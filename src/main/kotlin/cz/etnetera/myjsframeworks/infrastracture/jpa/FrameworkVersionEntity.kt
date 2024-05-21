package cz.etnetera.myjsframeworks.infrastracture.jpa

import jakarta.persistence.*
import java.time.LocalDate
import java.util.UUID

@Entity(name = "framework_version")
data class FrameworkVersionEntity (
    @Id
    val id: UUID,
    @Column(unique = true)
    val version: String,
    val deprecationDate: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "framework_id")
    val framework: FrameworkEntity
)