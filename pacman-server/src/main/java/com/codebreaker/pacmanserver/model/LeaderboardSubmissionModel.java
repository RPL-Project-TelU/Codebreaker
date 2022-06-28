package com.codebreaker.pacmanserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardSubmissionModel {
    private String name;
    private int score;
}
