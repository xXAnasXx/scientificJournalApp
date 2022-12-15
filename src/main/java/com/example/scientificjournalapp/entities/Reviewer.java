package com.example.scientificjournalapp.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Reviewer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameReviewer;
//    @OneToMany
//    private List<Submission> submissions;
//    @OneToMany
//    private List<Comment> comments;


}
