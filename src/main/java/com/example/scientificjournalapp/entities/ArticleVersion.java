package com.example.scientificjournalapp.entities;


import com.example.scientificjournalapp.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class ArticleVersion {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer versionID;
    private int submissionID;
    private File articleFile;
    @OneToMany
    private List<Comment> comments;
    private Status status;

}
