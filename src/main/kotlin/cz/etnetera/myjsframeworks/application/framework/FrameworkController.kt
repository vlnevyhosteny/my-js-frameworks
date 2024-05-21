package cz.etnetera.myjsframeworks.application.framework

import cz.etnetera.myjsframeworks.domain.framework.Framework
import cz.etnetera.myjsframeworks.domain.framework.FrameworkRanking
import cz.etnetera.myjsframeworks.domain.framework.FrameworkService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/frameworks")
@Validated
class FrameworkController(@Autowired private val frameworkService: FrameworkService) {
    @GetMapping
    fun findAll(@RequestParam(required = false) search: String?): List<Framework> {
        if (search != null) {
            return frameworkService.search(search)
        }

        return frameworkService.getAll()
    }

    @PostMapping
    fun createFramework(@Valid @RequestBody framework: CreateFrameworkDTO) = frameworkService.create(
        Framework(
            UUID.randomUUID(),
            framework.name,
            FrameworkRanking(framework.ranking),
            null,
        )
    )

}