package com.codebreaker.pacmanserver.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@Getter
@NoArgsConstructor
public class LeaderboardSubmission{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idSubmission;

    @Column(length=3)
    private String name; 

    private int score;
}
