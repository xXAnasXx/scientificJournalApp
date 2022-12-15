package com.example.scientificjournalapp.controller;

import com.example.scientificjournalapp.dao.SubmissionRepository;
import com.example.scientificjournalapp.entities.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SubmissionController {
    @Autowired
    private SubmissionRepository submissionRepository;

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
}
