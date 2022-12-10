package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewerRepository extends JpaRepository<Author, Integer> {
}
