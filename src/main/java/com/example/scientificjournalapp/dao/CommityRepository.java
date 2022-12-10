package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Committy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommityRepository extends JpaRepository<Committy, Integer> {
}
