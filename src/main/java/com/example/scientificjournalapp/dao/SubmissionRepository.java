package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
}
