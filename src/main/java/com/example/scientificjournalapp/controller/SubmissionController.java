package com.example.scientificjournalapp.controller;

import com.example.scientificjournalapp.dao.*;
import com.example.scientificjournalapp.entities.*;
import com.example.scientificjournalapp.enums.Status;
import com.example.scientificjournalapp.enums.SubmissionPhase;
import com.example.scientificjournalapp.utils.FileConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Transactional
public class SubmissionController {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    private ArticleVersionRepository articleVersionRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CommityRepository commityRepository;

//    private final String UPLOAD_DIR = "articles/";
    @GetMapping(path = "/displaySubmissions")
    public String listSubmissions(Model model){
        List<Submission> submissionList;
        submissionList = submissionRepository.findAll();
        for(Submission s : submissionList){
            System.out.println(s);
        }
        model.addAttribute("submissions",submissionList);
        return "views/submissionsView";
    }

    @GetMapping(path="/formSubmissions")
    public String formSubmissions(Model model) {
        //getting categories
        List<ArticleCategory> articleCategoryList = articleCategoryRepository.findAll();
        List<String> nomCategories = articleCategoryList.stream()
                .map(ArticleCategory::getName)
                .collect(Collectors.toList());
        // getting article versions
        List<ArticleVersion> articleVersionList = articleVersionRepository.findAll();
        List<Integer> idArticleVersionsInt = articleVersionList.stream()
                .map(ArticleVersion::getVersionID)
                .collect(Collectors.toList());

        List<String> idArticleVersions = new ArrayList<>();

        for(Integer i : idArticleVersionsInt){
            idArticleVersions.add(i.toString());
        }


        List<Author> authorsList = authorRepository.findAll();
        List<String> nomAuthors = authorsList.stream()
                .map(Author::getLastName)
                .collect(Collectors.toList());

        List<Committy> committyList = commityRepository.findAll();
        List<Integer> idCommittesInt = committyList.stream()
                .map(Committy::getId)
                .collect(Collectors.toList());

        List<String> idCommittes = new ArrayList<>();

        for(Integer i : idCommittesInt){
            idCommittes.add(i.toString());
        }

        String nomCategory = "";
        String idArticle = "";
        String nomAuthor = "";
        String idCommitte = "";
        model.addAttribute("nomCategories",nomCategories);
        model.addAttribute("idArticleVersions",idArticleVersions);
        model.addAttribute("nomAuthors",nomAuthors);
        model.addAttribute("idCommittes",idCommittes);
        model.addAttribute("nomCategory",nomCategory);
        model.addAttribute("idArticle",idArticle);
        model.addAttribute("nomAuthor",nomAuthor);
        model.addAttribute("idCommitte",idCommitte);
        model.addAttribute("submission", new Submission());
        model.addAttribute("dateError", "Date invalide");
        model.addAttribute("mode", "new");
        return "forms/formSubmissions";
    }
    @PostMapping(path="/saveSubmission")
    public String saveSubmission(@RequestParam("file") MultipartFile file, @ModelAttribute("nomCategory")String nomCategory,
                                 @ModelAttribute("idArticle")String idArticle,
                                 @ModelAttribute("nomAuthor")String nomAuthor,
                                 @ModelAttribute("idCommitte")String idCommitte,
                                 Submission submission, BindingResult bindingResult, RedirectAttributes attributes, Model model) throws IOException {
        if(bindingResult.hasErrors()) {return "forms/formSubmissions";}
        if (file.isEmpty()) {
            attributes.addFlashAttribute("message", "Please select a file to upload.");
            return "forms/formSubmissions";
        }
//        // normalize the file path
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // save the file on the local file system
//        try {
//            Path path = Paths.get(UPLOAD_DIR + fileName);
//            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // return success response
        attributes.addFlashAttribute("message", "You successfully uploaded !");

        ArticleVersion articleVersion = new ArticleVersion();
        File fileConverted = FileConverter.convert(file);
        articleVersion.setArticleFile(fileConverted);
        articleVersion.setComments(null);
        articleVersion.setStatus(null);
        submission.setArticle(articleVersion);

        ArticleCategory articleCategory = articleCategoryRepository.findByName(nomCategory);
        submission.setArticleCategory(articleCategory);

        Committy committy = commityRepository.findById(Integer.valueOf(idCommitte)).get();
        submission.setCommitty(committy);
        submission.setAuthor(authorRepository.findById(3).get());
        submission.setDate(new Date());
        submission.setSubmissionPhase(SubmissionPhase.REVIEW);
        submissionRepository.save(submission);
//        Societe societe = societeRepository.findByNom(nomSociete);
//        compte.setSociete(societe);
//        Devise devise = deviseRepository.findByCode(codeDevise);
//        compte.setDevise(devise);
//        Banque banque = banqueRepository.findByNom(nomBanque);
//        compte.setBanque(banque);
//        Agence agence = agenceRepository.findByNom(nomAgence);
//        compte.setAgence(agence);
//        compteRepository.save(compte);
        model.addAttribute("fileName", submission.getArticle().getArticleFile().getName());
        return "confirmation/confirmationSubmissions";
    }

    @GetMapping(path="/editSubmission")
    public String editSubmission(Model model, Integer id) {
        Submission submission = submissionRepository.findById(id).get();

        List<ArticleCategory> articleCategoryList = articleCategoryRepository.findAll();
        List<String> nomCategories = articleCategoryList.stream()
                .map(ArticleCategory::getName)
                .collect(Collectors.toList());

        List<Author> authorsList = authorRepository.findAll();
        List<String> nomAuthors = authorsList.stream()
                .map(Author::getLastName)
                .collect(Collectors.toList());

        model.addAttribute("nomCategories",nomCategories);
        model.addAttribute("nomAuthors",nomAuthors);
        model.addAttribute("submission", submission);
        model.addAttribute("dateError", "Date invalide");
        model.addAttribute("mode", "edit");
        return "forms/formSubmissions";
    }
    @GetMapping(path="/editSubmissionEval")
    public String editSubmissionEval(Model model, Integer id) {
        Submission submission = submissionRepository.findById(id).get();
        List<String> status = new ArrayList<>();
        for(Status s : Status.values()){
            status.add(s.toString());
        }
        model.addAttribute("submission", submission);
        model.addAttribute("status", status);
        model.addAttribute("mode", "edit");
        return "forms/formSubmissionsEval";
    }
    @PostMapping(path="/saveSubmissionEval")
    public String saveSubmissionEval(@ModelAttribute("statut")String statut,
                                 Submission submission, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors()) {return "forms/formSubmissionsEval";}
        ArticleVersion articleVersion = submission.getArticle();
        articleVersion.setStatus(Status.valueOf(statut));
        submission.setArticle(articleVersion);
        submission.setSubmissionPhase(SubmissionPhase.CAMERA_READY);
        submissionRepository.save(submission);
        return "confirmation/confirmationSubmissions";
    }
}
