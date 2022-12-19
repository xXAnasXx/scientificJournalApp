package com.example.scientificjournalapp.serviceInit;

import java.io.IOException;
import java.net.URISyntaxException;

public interface IJournalInitService {
    public void initArticleVersions() throws URISyntaxException, IOException;
    public void initAuthors();
    public void initCategories();
    public void initComments();
    public void initCommittees();
    public void initReviewers();
    public void initSubmissions();
}
