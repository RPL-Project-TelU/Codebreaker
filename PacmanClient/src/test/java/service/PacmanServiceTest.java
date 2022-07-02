package service;

import com.codebreaker.pacmanclient.models.Ghost;
import com.codebreaker.pacmanclient.services.PacmanService;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class PacmanServiceTest {

    // New PacmanService
    static PacmanService ps = new PacmanService();

    @Test
    public void testContinueLevel() {
        final int validSpeeds[] = { 1, 2, 3, 4, 6, 8 };
        
        Ghost ghost = new Ghost();
        ghost.setSpeed(validSpeeds[1]);  //Speed awal = 2
        ps.getGhosts()[0] = ghost;

        int sebelum = ps.getGhosts()[0].getSpeed(); // == 2
        ps.continueLevel();
        int sesudah = ps.getGhosts()[0].getSpeed(); // >= 2
        
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
