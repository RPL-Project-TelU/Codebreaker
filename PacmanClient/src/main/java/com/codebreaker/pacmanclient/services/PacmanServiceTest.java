package com.codebreaker.pacmanclient.services;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PacmanServiceTest {

    // New PacmanService
    static PacmanService ps = new PacmanService();

    @Test
    public void testContinueLevel() {
        final int validSpeeds[] = { 1, 2, 3, 4, 6, 8 };
        
        Ghost ghost = new Ghost();
        ghost.setSpeed(validSpeeds[1]);  //Speed awal = 2
        ps.ghosts[0] = ghost;

        int sebelum = ps.ghosts[0].getSpeed(); // == 2
        ps.continueLevel();
        int sesudah = ps.ghosts[0].getSpeed(); // >= 2
        
        for (int i = 0; i < validSpeeds.length; i++){
            if (sebelum > sesudah){
                assertEquals(validSpeeds[i], sesudah);
            }else if (sebelum <= sesudah && validSpeeds[i] == sesudah){
                assertEquals(validSpeeds[i], sesudah);
            }
        }
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