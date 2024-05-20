package cz.etnetera.myjsframeworks.domain

interface FrameworkRepository {
    fun findAll(): List<Framework>
}