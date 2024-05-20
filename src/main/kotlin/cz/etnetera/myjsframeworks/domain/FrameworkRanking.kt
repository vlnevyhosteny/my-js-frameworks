package cz.etnetera.myjsframeworks.domain

data class FrameworkRanking(val stars: Int) {
    fun validate() {
        if (stars < 1 || stars > 5) {
            throw DomainException("Stars must be a positive number")
        }
    }
}
