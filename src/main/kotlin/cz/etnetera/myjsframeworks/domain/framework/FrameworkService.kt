package cz.etnetera.myjsframeworks.domain.framework

interface FrameworkService {
    fun getAll(): List<Framework>
    fun search(input: String): List<Framework>
    fun create(framework: Framework)
}