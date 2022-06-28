package com.codebreaker.pacmanserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codebreaker.pacmanserver.entity.LeaderboardSubmission;
import com.codebreaker.pacmanserver.model.LeaderboardSubmissionModel;
import com.codebreaker.pacmanserver.service.LeaderboardSubmissionService;

@RestController
public class LeaderboardSubmissionController {
    
    @Autowired
    private LeaderboardSubmissionService lService;

    @PostMapping("/api/submit")
    public String submitSubmission(@RequestBody LeaderboardSubmissionModel sModel) {
        LeaderboardSubmission submission = lService.newSubmission(sModel.getName(), sModel.getScore());
        if(submission == null){
            return "Failed";
        } else {
            return "Success";
        }
    }

    @GetMapping("/api/getLeaderboard")
    public List<LeaderboardSubmission> getTopSubmission(){
        return lService.getTopSubmission();
    }

    @DeleteMapping("/api/delete/{id}")
    public String removeSubmission(@PathVariable Long id){
        try {
            lService.removeSubmission(id);
        } catch (Exception e) {
            return e.getMessage();
        }
        
        return String.format("Submission with id of %s successfully deleted",id);
    }
}
