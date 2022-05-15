package com.devskiller.spring.security.task

import com.devskiller.spring.security.task.base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.test.context.support.WithMockUser

import static com.devskiller.spring.security.task.SecurityInitializer.USER_NAME_1

class ServiceSpec extends IntegrationSpec {
    @Autowired ArticleCrudService service
    String title = "title"

    @WithMockUser(USER_NAME_1)
    def "only author can create his article"() {
        given:
            Article article = new Article(title, "someOtherAuthor")
        when:
            service.add(article)
        then:
            thrown(AccessDeniedException)
        when:
            service.add(new Article(title, USER_NAME_1))
        then:
            service.get(title).createdBy == USER_NAME_1
    }
}
