package service;

import com.codebreaker.pacmanclient.models.Ghost;
import com.codebreaker.pacmanclient.services.PacmanService;
import com.codebreaker.pacmanclient.models.Level;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class PacmanServiceTest {

    // New PacmanService
    static PacmanService ps = new PacmanService();

    @Test
    public void testContinueLevel() {
        final int validSpeeds[] = { 1, 2, 3, 4, 6, 8 };
        
        Ghost ghost = new Ghost();

        // Speed awal = 2
        ghost.setSpeed(validSpeeds[1]);
        ps.getGhosts()[0] = ghost;
        
        // Speed ghost sesudah harus >= sebelum
        int sebelum = ps.getGhosts()[0].getSpeed();
        ps.continueLevel();
        int sesudah = ps.getGhosts()[0].getSpeed();
        
        for (int i = 0; i < validSpeeds.length; i++){
            if (sesudah >= sebelum && validSpeeds[i] == sesudah){
                assertEquals(validSpeeds[i], sesudah);
            }else if (sesudah < sebelum){
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
        final int[][] levels = {
            {
                    19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
                    17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                    25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
                    0, 0, 0, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
                    19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
                    17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21,
                    17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21,
                    17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21,
                    17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
                    17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
                    21, 0, 0, 0, 0, 0, 0, 0, 17, 16, 16, 16, 16, 16, 20,
                    17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
                    17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                    17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
                    25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
            }
        };

        // Convert ke array 1D karena ScreenData bertipe 1D
        short[] isiLevel = new short[225];
        for (int i = 0; i < 225; i++){
            isiLevel[i] = (short) levels[0][i];
        }
        
        ps.initLevel();
        assertArrayEquals(isiLevel, ps.getScreenData());
    }

    @Test
    public void testMoveGhosts() {

    }

    @Test
    public void testMovePacman() {

    }
}
