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
        
        // Pengecekan dengan for loop
        for (int i = 0; i < validSpeeds.length; i++){
            if (sesudah >= sebelum && validSpeeds[i] == sesudah){
                assertEquals(validSpeeds[i], sesudah);
            }
        }

        // Jika tidak sesuai perkiraan
        assertEquals(0, sesudah);
    }

    @Test
    public void testDecreaseHealth1() {
        // set health 5 dan game sedang dimainkan (inGame = true)
        int health = 5;
        ps.setInGame(true);
        ps.setLives(health);
        ps.decreaseHealt();

        // Pacman masih hidup karena helath masih 4
        boolean status = ps.getInGame();
        assertEquals(true, status);
    }

    @Test
    public void testDecreaseHealth2() {
        // set health 5 dan game sedang dimainkan (inGame = true)
        int health = 5;
        ps.setInGame(true);
        ps.setLives(health);
        ps.decreaseHealt();
        ps.decreaseHealt();
        ps.decreaseHealt();
        ps.decreaseHealt();
        ps.decreaseHealt();

        // Pacman mati karena health = 0, game tidak dimainkan (inGame = false)
        boolean status = ps.getInGame();
        assertEquals(false, status);
    }

    @Test
    public void testInitLevel() {
        // Ambil data levels
        int[][] levels = Level.levels;

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
