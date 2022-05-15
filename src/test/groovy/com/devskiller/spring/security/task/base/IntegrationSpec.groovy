package com.devskiller.spring.security.task.base

import com.devskiller.spring.security.task.App
import groovy.transform.TypeChecked
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(classes = [App])
@TypeChecked
class IntegrationSpec extends Specification {
}
