package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Integer> {
}
