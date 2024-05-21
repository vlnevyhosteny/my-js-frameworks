package cz.etnetera.myjsframeworks.application

import cz.etnetera.myjsframeworks.domain.Framework
import cz.etnetera.myjsframeworks.domain.FrameworkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/frameworks")
class FrameworkController (@Autowired private val frameworkService: FrameworkService) {
    @GetMapping
    fun findAll(@RequestParam(required = false) search: String?) : List<Framework> {
        if (search != null) {
            return frameworkService.search(search)
        }

        return frameworkService.getAll()
    }
}