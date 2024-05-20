package cz.etnetera.myjsframeworks.domain

class DomainFrameworkService (private val frameworkRepository: FrameworkRepository) : FrameworkService {
    override fun findAll(): List<Framework> {
        return frameworkRepository.findAll()
    }
}