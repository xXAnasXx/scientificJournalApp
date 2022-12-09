package com.example.scientificjournalapp.entities;


import com.example.scientificjournalapp.enums.SubmissionPhase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Submission {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer submissionId;
    @ManyToOne
    private Category category;
    @OneToOne
    private ArticleVersion article;
    @ManyToOne
    private Author author;
    private SubmissionPhase submissionPhase;
    @ManyToOne
    private Committy committy;
    private Date date;
}
