package cz.etnetera.myjsframeworks

import cz.etnetera.myjsframeworks.domain.FrameworkRepository
import cz.etnetera.myjsframeworks.infrastracture.BeanConfiguration
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(BeanConfiguration::class)
class FrameworkH2RepositoryTests {
    @Autowired
    private lateinit var frameworkRepository: FrameworkRepository

    @Test
    fun search_shouldReturnFrameworks() {
        var frameworks = frameworkRepository.search("Re")
        assert(frameworks.isNotEmpty())
        assertTrue(frameworks.any { it.name == "React" } )

        frameworks = frameworkRepository.search("2.6")
        assert(frameworks.isNotEmpty())
        assertTrue(frameworks.count { it.name == "Vue.js" } == 1)

        frameworks = frameworkRepository.search("NotExistingFramework")
        assert(frameworks.isEmpty())
    }
}