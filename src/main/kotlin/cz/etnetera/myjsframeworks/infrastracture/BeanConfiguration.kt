package cz.etnetera.myjsframeworks.infrastracture

import cz.etnetera.myjsframeworks.domain.DomainFrameworkService
import cz.etnetera.myjsframeworks.domain.FrameworkRepository
import cz.etnetera.myjsframeworks.domain.FrameworkService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {
    @Bean
    fun frameworkService(@Autowired frameworkRepository: FrameworkRepository): FrameworkService {
        return DomainFrameworkService(frameworkRepository)
    }
}