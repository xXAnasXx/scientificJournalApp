package com.example.scientificjournalapp.controller;

import com.example.scientificjournalapp.dao.ArticleCategoryRepository;
import com.example.scientificjournalapp.entities.ArticleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

//    @Autowired
//    private ArticleCategoryRepository articleCategoryRepository;
//
//    @GetMapping(path = "/displayCategories")
//    public String listCategories(Model model){
//        List<ArticleCategory> articleCategoryList;
//        articleCategoryList = articleCategoryRepository.findAll();
//        model.addAttribute("categories",articleCategoryList);
//        return "views/categoriesView";
//    }
}
