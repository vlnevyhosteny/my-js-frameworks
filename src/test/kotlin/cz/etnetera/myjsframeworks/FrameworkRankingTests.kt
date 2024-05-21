package cz.etnetera.myjsframeworks

import cz.etnetera.myjsframeworks.domain.exception.DomainException
import cz.etnetera.myjsframeworks.domain.framework.FrameworkRanking
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FrameworkRankingTests {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun validate_shouldNotThrow(stars: Int) {
        val ranking = FrameworkRanking(stars)

        assertDoesNotThrow {
            ranking.validate()
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 6])
    fun validate_shouldThrow(stars: Int) {
        val ranking = FrameworkRanking(stars)

        assertThrows<DomainException> {
            ranking.validate()
        }
    }
}