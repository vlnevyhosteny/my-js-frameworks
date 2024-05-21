package cz.etnetera.myjsframeworks.domain

interface FrameworkService {
    fun getAll(): List<Framework>
    fun search(input: String): List<Framework>
}