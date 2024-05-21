package cz.etnetera.myjsframeworks.infrastracture

import cz.etnetera.myjsframeworks.domain.framework.*
import cz.etnetera.myjsframeworks.infrastracture.jpa.FrameworkJPARepository
import cz.etnetera.myjsframeworks.infrastracture.jpa.FrameworkVersionJPARepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.time.LocalDate
import java.util.*

@EnableJpaRepositories(basePackageClasses = [FrameworkJPARepository::class, FrameworkVersionJPARepository::class])
@Configuration
@ComponentScan
class BeanConfiguration {
    @Bean("frameworkService")
    fun frameworkService(@Autowired frameworkRepository: FrameworkRepository): FrameworkService {
        return DomainFrameworkService(frameworkRepository)
    }

    @Bean
    fun seedDb(@Autowired frameworkRepository: FrameworkRepository) = CommandLineRunner {
        val frameworks = listOf(
            Framework(
                id = UUID.randomUUID(),
                name = "React",
                versions = listOf(
                    FrameworkVersion(
                        "17.0.2",
                        LocalDate.of(2021, 5, 22)
                    ),
                    FrameworkVersion(
                        "16.14.0",
                        LocalDate.of(2020, 11, 13)
                    )
                ),
                ranking = FrameworkRanking(1)
            ),
            Framework(
                id = UUID.randomUUID(),
                name = "Vue.js",
                versions = listOf(
                    FrameworkVersion(
                        "3.0.0",
                        LocalDate.of(2020, 9, 18)
                    ),
                    FrameworkVersion(
                        "2.6.12",
                        LocalDate.of(2020, 9, 18)
                    )
                ),
                ranking = FrameworkRanking(2)
            ),
        )

        frameworks.forEach { frameworkRepository.create(it) }
    }
}