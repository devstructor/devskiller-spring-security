package com.devskiller.spring.security.task;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

@Component
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ArticleCrudService {
    private Map<String, Article> store = new ConcurrentHashMap();

    @PreAuthorize("#article.createdBy == authentication.principal.username")
    public void add(Article article) {
        requireNonNull(article);
        store.put(article.title, article);
    }

    @PostAuthorize("returnObject.createdBy == authentication.principal.username")
    public Article get(String title) {
        requireNonNull(title);
        return store.get(title);
    }
}
