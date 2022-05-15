package com.devskiller.spring.security.task;

import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;

import static java.util.Objects.*;

@Component
public class ArticleCrudService {
    private Map<String, Article> store = new ConcurrentHashMap();

    public void add(Article article) {
        requireNonNull(article);
        store.put(article.title, article);
    }

    public Article get(String title) {
        requireNonNull(title);
        return store.get(title);
    }
}