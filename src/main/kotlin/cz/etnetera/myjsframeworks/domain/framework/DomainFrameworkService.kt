package cz.etnetera.myjsframeworks.domain.framework

class DomainFrameworkService (private val frameworkRepository: FrameworkRepository) : FrameworkService {
    override fun getAll(): List<Framework> {
        return frameworkRepository.getAll()
    }
    override fun search(input: String): List<Framework> {
        return frameworkRepository.search(input)
    }
    override fun create(framework: Framework) {
        frameworkRepository.create(framework)
    }
}