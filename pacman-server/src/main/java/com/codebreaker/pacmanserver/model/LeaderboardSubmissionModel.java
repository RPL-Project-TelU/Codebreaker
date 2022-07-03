package com.codebreaker.pacmanserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LeaderboardSubmissionModel {
    private String name;
    private int score;
}
