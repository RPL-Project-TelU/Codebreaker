package com.codebreaker.pacmanserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LeaderboardSubmission implements Comparable<LeaderboardSubmission>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSubmission;

    @Column(length=3)
    private String name; 

    private int score;


    @Override
    public int compareTo(LeaderboardSubmission o) {
        return o.getScore() - this.score;
    }     
}
