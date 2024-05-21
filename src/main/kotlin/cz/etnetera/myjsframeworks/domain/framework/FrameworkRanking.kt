package cz.etnetera.myjsframeworks.domain.framework

import cz.etnetera.myjsframeworks.domain.exception.DomainException

data class FrameworkRanking(val stars: Int) {
    fun validate() {
        if (stars < 1 || stars > 5) {
            throw DomainException("Stars must be a positive number")
        }
    }
}
