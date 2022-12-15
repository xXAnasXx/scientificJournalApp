package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Reviewer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewerRepository extends JpaRepository<Reviewer, Integer> {
}
