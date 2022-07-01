package com.codebreaker.pacmanclient.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PacmanServiceTest {

    // New PacmanService
    static PacmanService ps = new PacmanService();

    @Test
    public void testContinueLevel() {

    }

    @Test
    public void testDecreaseHealth1() {
        int health = 10;
        ps.setInGame(true);
        ps.setLives(health);
        ps.decreaseHealt();
        boolean status = ps.getInGame();
        assertEquals(true, status);
    }

    @Test
    public void testDecreaseHealth2() {
        int health = 1;
        ps.setInGame(true);
        ps.setLives(health);
        ps.decreaseHealt();
        boolean status = ps.getInGame();
        assertEquals(false, status);
    }

    @Test
    public void testInitLevel() {

    }

    @Test
    public void testMoveGhosts() {

    }

    @Test
    public void testMovePacman() {

    }
}
