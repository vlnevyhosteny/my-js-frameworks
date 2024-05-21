package cz.etnetera.myjsframeworks.domain

class DomainFrameworkService (private val frameworkRepository: FrameworkRepository) : FrameworkService {
    override fun getAll(): List<Framework> {
        return frameworkRepository.getAll()
    }
    override fun search(input: String): List<Framework> {
        return frameworkRepository.search(input)
    }
}