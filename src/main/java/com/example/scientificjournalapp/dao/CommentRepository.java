package com.example.scientificjournalapp.dao;

import com.example.scientificjournalapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
