package com.example.scientificjournalapp.service;

import com.example.scientificjournalapp.dao.CategoryRepository;
import com.example.scientificjournalapp.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Stream;

public class IJournalInitServiceImpl implements IJournalInitService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initArticleVersions() {

    }

    @Override
    public void initAuthors() {

    }

    @Override
    public void initCategories() {
        Stream.of("Brief Report", "Case Report", "Communication", "Conference Report", "Editorial", "Essay","Review","Protocol").
                forEach(a -> {
                    Category c = new Category();
                    c.setName(a);
                    categoryRepository.save(c);
                });
    }

    @Override
    public void initComments() {

    }

    @Override
    public void initCommittees() {

    }

    @Override
    public void initReviewers() {

    }

    @Override
    public void initSubmissions() {

    }
}
