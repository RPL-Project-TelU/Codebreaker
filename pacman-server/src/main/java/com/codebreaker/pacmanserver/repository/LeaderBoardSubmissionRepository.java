package com.codebreaker.pacmanserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codebreaker.pacmanserver.entity.LeaderboardSubmission;

@Repository
public interface LeaderBoardSubmissionRepository extends JpaRepository<LeaderboardSubmission, Long> {
    List<LeaderboardSubmission> findFirst10ByOrderByScoreDesc();
}
