package com.devskiller.spring.security.task;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

@Component
public class ArticleCrudService {
    private Map<String, Article> store = new ConcurrentHashMap();

    // no time ;-) sorry
//    @PreAuthorize("#article.createdBy = authentication.principal")
    public void add(Article article) {
        requireNonNull(article);
        // why not just set createdBy to SecurityContextHolder.getContext().getAuthentication() ?
        store.put(article.title, article);
    }

    @PostAuthorize("returnObject.createdBy == authentication.principal")
    public Article get(String title) {
        requireNonNull(title);
        return store.get(title);
    }
}
