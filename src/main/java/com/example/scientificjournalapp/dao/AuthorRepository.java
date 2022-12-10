package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
