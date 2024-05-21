package cz.etnetera.myjsframeworks.domain.framework

interface FrameworkRepository {
    fun getAll(): List<Framework>
    fun create(framework: Framework): Framework
    fun search(input: String): List<Framework>
}