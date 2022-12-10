package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
