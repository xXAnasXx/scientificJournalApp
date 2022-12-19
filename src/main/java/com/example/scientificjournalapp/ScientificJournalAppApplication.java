package com.example.scientificjournalapp;

import com.example.scientificjournalapp.serviceInit.IJournalInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScientificJournalAppApplication implements CommandLineRunner {
    @Autowired
    private IJournalInitService journalInitService;

    public static void main(String[] args) {
        SpringApplication.run(ScientificJournalAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        journalInitService.initComments();
        journalInitService.initCategories();
        journalInitService.initAuthors();
        journalInitService.initReviewers();
        journalInitService.initCommittees();
        journalInitService.initArticleVersions();
        journalInitService.initSubmissions();
    }
}
