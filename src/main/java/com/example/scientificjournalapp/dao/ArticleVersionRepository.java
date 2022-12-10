package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.ArticleVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleVersionRepository extends JpaRepository<ArticleVersion, Integer> {
}
