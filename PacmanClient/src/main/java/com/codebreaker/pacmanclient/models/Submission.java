package com.codebreaker.pacmanclient.models;

public class Submission {
    private Long id;
    private String name;
    private int score;

    public Submission(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Submission() {
    }

    public Submission(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("{\"name\":\"%s\",\"score\":%s}", name, score);
    }
    
}
