package com.example.scientificjournalapp.serviceInit;

import com.example.scientificjournalapp.dao.*;
import com.example.scientificjournalapp.entities.*;
import com.example.scientificjournalapp.enums.Status;
import com.example.scientificjournalapp.enums.SubmissionPhase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
public class IJournalInitServiceImpl implements IJournalInitService{

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private ReviewerRepository reviewerRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleVersionRepository articleVersionRepository;

    @Autowired
    private CommityRepository committyRepository;

    @Autowired
    private SubmissionRepository submissionRepository;
    @Override
    public void initArticleVersions() throws IOException {
        ArticleVersion articleVersion1 = new ArticleVersion();
        List<Comment> commentList = new ArrayList<>();
        commentList.add(commentRepository.findById(1).get());
        commentList.add(commentRepository.findById(2).get());
        articleVersion1.setStatus(Status.ACCEPTED);
        articleVersion1.setComments(commentList);
        File resource = new ClassPathResource(
                "articles/A_Study_on_the_Role_of_Software_Architecture_in_the_Evolution_and_Quality_of_Software.pdf").getFile();
        articleVersion1.setArticleFile(resource);
//        System.out.println(articleVersion1.getArticleFile().getName());

        ArticleVersion articleVersion2 = new ArticleVersion();
        List<Comment> commentList2 = new ArrayList<>();
        commentList2.add(commentRepository.findById(3).get());
        articleVersion2.setStatus(Status.ACCEPTED_MINOR_COMMENTS);
        articleVersion2.setComments(commentList2);
        File resource2 = new ClassPathResource("articles/Using_Software_Metrics_for_Predicting_Vulnerable_Code-Components_A_Study_on_Java_and_Python_Open_Source_Projects.pdf").getFile();
        articleVersion2.setArticleFile(resource2);

        articleVersionRepository.save(articleVersion1);
        articleVersionRepository.save(articleVersion2);
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
        Stream.of("Comment 01", "Comment 02", "Comment 03").
                forEach(a -> {
                    Comment cm = new Comment();
                    cm.setText(a);
                    commentRepository.save(cm);
                });
    }

    @Override
    public void initCommittees() {
        Committy committy1 = new Committy();
        List<Reviewer> reviewerList = new ArrayList<>();
        reviewerList.add(reviewerRepository.findById(1).get());
        reviewerList.add(reviewerRepository.findById(3).get());
        committy1.setReviewers(reviewerList);
        committyRepository.save(committy1);

        Committy committy2 = new Committy();
        List<Reviewer> reviewerList2 = new ArrayList<>();
        reviewerList2.add(reviewerRepository.findById(2).get());
        reviewerList2.add(reviewerRepository.findById(4).get());
        reviewerList2.add(reviewerRepository.findById(7).get());
        reviewerList2.add(reviewerRepository.findById(8).get());
        committy2.setReviewers(reviewerList2);
        committyRepository.save(committy2);
    }

    @Override
    public void initReviewers() {
        Stream.of("Reviewer 01", "Reviewer 02", "Reviewer 03", "Reviewer 04", "Reviewer 05", "Reviewer 06","Reviewer 07","Reviewer 08").
                forEach(s -> {
                    Reviewer r = new Reviewer();
                    r.setNameReviewer(s);
                    reviewerRepository.save(r);
                });
    }

    @Override
    public void initSubmissions() {
        Submission submission1 = new Submission();
        submission1.setArticleCategory(articleCategoryRepository.findById(2).get());
        submission1.setArticle(articleVersionRepository.findById(1).get());
        submission1.setAuthor(authorRepository.findById(1).get());
        submission1.setSubmissionPhase(SubmissionPhase.REVIEW);
        submission1.setCommitty(committyRepository.findById(1).get());
        submission1.setDate(new Date());
        submissionRepository.save(submission1);

        Submission submission2 = new Submission();
        submission2.setArticleCategory(articleCategoryRepository.findById(2).get());
        submission2.setArticle(articleVersionRepository.findById(2).get());
        submission2.setAuthor(authorRepository.findById(2).get());
        submission2.setSubmissionPhase(SubmissionPhase.REVIEW);
        submission2.setCommitty(committyRepository.findById(2).get());
        submission2.setDate(new Date());
        submissionRepository.save(submission2);

    }
}
