# Task definition
You are working on securing an enterprise application. Your task is to allow only the article author to create and read an article with his name, using method annotations.

# Instructions
Use Spring Security annotations to secure methods on ArticleCrudService to allow only the author of an article to create and read his/her article. In other words: 
- if author1 created an article, this article cannot be read by author2,
- if the author creates an article, that article has to have his name in `createdBy` field.


Edit ONLY ANNOTATIONS on ArticleCrudService class.

# Technical requirements
- Spring Security
- Java

# Copyright
Copyright 2018 Devskiller. All rights reserved.