package com.codebreaker.pacmanserver.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codebreaker.pacmanserver.entity.LeaderboardSubmission;
import com.codebreaker.pacmanserver.repository.LeaderBoardSubmissionRepository;

@Service
public class LeaderboardSubmissionService{
    
    @Autowired
    private LeaderBoardSubmissionRepository leaderBoardSubmissionRepository;

    public LeaderboardSubmission newSubmission(String name, int score) throws IllegalArgumentException{
        if (name.length() != 3){
            return null;
        }
        LeaderboardSubmission submission = new LeaderboardSubmission();
        submission.setName(name);
        submission.setScore(score);
        leaderBoardSubmissionRepository.save(submission);
        return submission;
    }

    public List<LeaderboardSubmission> getTopSubmission(){
        return leaderBoardSubmissionRepository.findFirst10ByOrderByScoreDesc();
    }

    public void removeSubmission(long id) throws Exception{
        Optional<LeaderboardSubmission> submission = leaderBoardSubmissionRepository.findById(id);
        if(submission != null){
            leaderBoardSubmissionRepository.deleteById(id);
        } else {
            throw new Exception("ID Not Found");
        }
    }
}