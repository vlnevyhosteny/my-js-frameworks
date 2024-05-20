package cz.etnetera.myjsframeworks.domain

class DomainFrameworkService (private val frameworkRepository: FrameworkRepository) : FrameworkService {
    override fun getAll(): List<Framework> {
        return frameworkRepository.getAll()
    }
}