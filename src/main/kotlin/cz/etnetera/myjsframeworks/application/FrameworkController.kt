package cz.etnetera.myjsframeworks.application

import cz.etnetera.myjsframeworks.domain.Framework
import cz.etnetera.myjsframeworks.domain.FrameworkRanking
import cz.etnetera.myjsframeworks.domain.FrameworkService
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