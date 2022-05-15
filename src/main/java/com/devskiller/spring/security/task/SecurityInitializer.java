package com.devskiller.spring.security.task;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.*;
import org.springframework.security.config.annotation.web.configuration.*;

import java.util.*;

@Configuration
@EnableWebSecurity
public class SecurityInitializer extends WebSecurityConfigurerAdapter {
    public static final String USER_NAME_1 = "user1";
    public static final String USER_NAME_2 = "user2";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        registerUsers(auth, USER_NAME_1, USER_NAME_2);
    }

    private void registerUsers(AuthenticationManagerBuilder auth, String... userNames) throws Exception {
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryAuthentication = auth.inMemoryAuthentication();
        Arrays.stream(userNames)
                .forEach((user) ->
                        inMemoryAuthentication.withUser(user)
                                .password(UUID.randomUUID().toString())
                                .authorities(Collections.emptyList())
                                .and());
    }
}