package com.example.scientificjournalapp.service;

import com.example.scientificjournalapp.dao.AuthorRepository;
import com.example.scientificjournalapp.dao.ArticleCategoryRepository;
import com.example.scientificjournalapp.entities.Author;
import com.example.scientificjournalapp.entities.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class IJournalInitServiceImpl implements IJournalInitService{

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void initArticleVersions() {

    }

    @Override
    public void initAuthors() {
        Author a1 = new Author();
        a1.setFirstName("Jean");
        a1.setLastName("Baptiste");
        a1.setMail("jeanb@gmail.com");
        authorRepository.save(a1);

        Author a2 = new Author();
        a2.setFirstName("Etienne");
        a2.setLastName("Donneger");
        a2.setMail("etiennedon@gmail.com");
        authorRepository.save(a2);

        Author a3 = new Author();
        a3.setFirstName("Anass");
        a3.setLastName("Abouzakaria");
        a3.setMail("abAnass@gmail.com");
        authorRepository.save(a3);
    }

    @Override
    public void initCategories() {
        Stream.of("Brief Report", "Case Report", "Communication", "Conference Report", "Editorial", "Essay","Review","Protocol").
                forEach(a -> {
                    ArticleCategory c = new ArticleCategory();
                    c.setName(a);
                    articleCategoryRepository.save(c);
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
