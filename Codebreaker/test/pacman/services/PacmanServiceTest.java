/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pacman.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pacman.models.Ghost;
import pacman.models.Level;
import pacman.models.Pacman;

/**
 *
 * @author Acer
 */
public class PacmanServiceTest {
    
    public PacmanServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isDying method, of class PacmanService.
     */
    @Test
    public void testIsDying() {
        System.out.println("isDying");
        PacmanService instance = new PacmanService();
        boolean expResult = false;
        boolean result = instance.isDying();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decreaseHealt method, of class PacmanService.
     */
    @Test
    public void testDecreaseHealt() {
        System.out.println("decreaseHealt");
        PacmanService instance = new PacmanService();
        instance.decreaseHealt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initGame method, of class PacmanService.
     */
    @Test
    public void testInitGame() {
        System.out.println("initGame");
        PacmanService instance = new PacmanService();
        instance.initGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initLevel method, of class PacmanService.
     */
    @Test
    public void testInitLevel() {
        System.out.println("initLevel");
        PacmanService instance = new PacmanService();
        instance.initLevel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class PacmanService.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of movePacman method, of class PacmanService.
     */
    @Test
    public void testMovePacman() {
        System.out.println("movePacman");
        PacmanService instance = new PacmanService();
        instance.movePacman();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveGhosts method, of class PacmanService.
     */
    @Test
    public void testMoveGhosts() {
        System.out.println("moveGhosts");
        PacmanService instance = new PacmanService();
        instance.moveGhosts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of continueLevel method, of class PacmanService.
     */
    @Test
    public void testContinueLevel() {
        System.out.println("continueLevel");
        PacmanService instance = new PacmanService();
        instance.continueLevel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInGame method, of class PacmanService.
     */
    @Test
    public void testIsInGame() {
        System.out.println("isInGame");
        PacmanService instance = new PacmanService();
        boolean expResult = false;
        boolean result = instance.isInGame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInGame method, of class PacmanService.
     */
    @Test
    public void testGetInGame() {
        System.out.println("getInGame");
        PacmanService instance = new PacmanService();
        boolean expResult = false;
        boolean result = instance.getInGame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInGame method, of class PacmanService.
     */
    @Test
    public void testSetInGame() {
        System.out.println("setInGame");
        boolean inGame = false;
        PacmanService instance = new PacmanService();
        instance.setInGame(inGame);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDying method, of class PacmanService.
     */
    @Test
    public void testGetDying() {
        System.out.println("getDying");
        PacmanService instance = new PacmanService();
        boolean expResult = false;
        boolean result = instance.getDying();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDying method, of class PacmanService.
     */
    @Test
    public void testSetDying() {
        System.out.println("setDying");
        boolean dying = false;
        PacmanService instance = new PacmanService();
        instance.setDying(dying);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMAX_GHOSTS method, of class PacmanService.
     */
    @Test
    public void testGetMAX_GHOSTS() {
        System.out.println("getMAX_GHOSTS");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getMAX_GHOSTS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPACMAN_SPEED method, of class PacmanService.
     */
    @Test
    public void testGetPACMAN_SPEED() {
        System.out.println("getPACMAN_SPEED");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getPACMAN_SPEED();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getN_GHOSTS method, of class PacmanService.
     */
    @Test
    public void testGetN_GHOSTS() {
        System.out.println("getN_GHOSTS");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getN_GHOSTS();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setN_GHOSTS method, of class PacmanService.
     */
    @Test
    public void testSetN_GHOSTS() {
        System.out.println("setN_GHOSTS");
        int N_GHOSTS = 0;
        PacmanService instance = new PacmanService();
        instance.setN_GHOSTS(N_GHOSTS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLives method, of class PacmanService.
     */
    @Test
    public void testGetLives() {
        System.out.println("getLives");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getLives();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLives method, of class PacmanService.
     */
    @Test
    public void testSetLives() {
        System.out.println("setLives");
        int lives = 0;
        PacmanService instance = new PacmanService();
        instance.setLives(lives);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class PacmanService.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        PacmanService instance = new PacmanService();
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDx method, of class PacmanService.
     */
    @Test
    public void testGetDx() {
        System.out.println("getDx");
        PacmanService instance = new PacmanService();
        int[] expResult = null;
        int[] result = instance.getDx();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDx method, of class PacmanService.
     */
    @Test
    public void testSetDx() {
        System.out.println("setDx");
        int[] dx = null;
        PacmanService instance = new PacmanService();
        instance.setDx(dx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDy method, of class PacmanService.
     */
    @Test
    public void testGetDy() {
        System.out.println("getDy");
        PacmanService instance = new PacmanService();
        int[] expResult = null;
        int[] result = instance.getDy();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDy method, of class PacmanService.
     */
    @Test
    public void testSetDy() {
        System.out.println("setDy");
        int[] dy = null;
        PacmanService instance = new PacmanService();
        instance.setDy(dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGhosts method, of class PacmanService.
     */
    @Test
    public void testGetGhosts() {
        System.out.println("getGhosts");
        PacmanService instance = new PacmanService();
        Ghost[] expResult = null;
        Ghost[] result = instance.getGhosts();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGhosts method, of class PacmanService.
     */
    @Test
    public void testSetGhosts() {
        System.out.println("setGhosts");
        Ghost[] ghosts = null;
        PacmanService instance = new PacmanService();
        instance.setGhosts(ghosts);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPacman method, of class PacmanService.
     */
    @Test
    public void testGetPacman() {
        System.out.println("getPacman");
        PacmanService instance = new PacmanService();
        Pacman expResult = null;
        Pacman result = instance.getPacman();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPacman method, of class PacmanService.
     */
    @Test
    public void testSetPacman() {
        System.out.println("setPacman");
        Pacman pacman = null;
        PacmanService instance = new PacmanService();
        instance.setPacman(pacman);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReq_dx method, of class PacmanService.
     */
    @Test
    public void testGetReq_dx() {
        System.out.println("getReq_dx");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getReq_dx();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReq_dx method, of class PacmanService.
     */
    @Test
    public void testSetReq_dx() {
        System.out.println("setReq_dx");
        int req_dx = 0;
        PacmanService instance = new PacmanService();
        instance.setReq_dx(req_dx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReq_dy method, of class PacmanService.
     */
    @Test
    public void testGetReq_dy() {
        System.out.println("getReq_dy");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getReq_dy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReq_dy method, of class PacmanService.
     */
    @Test
    public void testSetReq_dy() {
        System.out.println("setReq_dy");
        int req_dy = 0;
        PacmanService instance = new PacmanService();
        instance.setReq_dy(req_dy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class PacmanService.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        PacmanService instance = new PacmanService();
        Level expResult = null;
        Level result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLevel method, of class PacmanService.
     */
    @Test
    public void testSetLevel() {
        System.out.println("setLevel");
        Level level = null;
        PacmanService instance = new PacmanService();
        instance.setLevel(level);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValidSpeeds method, of class PacmanService.
     */
    @Test
    public void testGetValidSpeeds() {
        System.out.println("getValidSpeeds");
        PacmanService instance = new PacmanService();
        int[] expResult = null;
        int[] result = instance.getValidSpeeds();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxSpeed method, of class PacmanService.
     */
    @Test
    public void testGetMaxSpeed() {
        System.out.println("getMaxSpeed");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getMaxSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentSpeed method, of class PacmanService.
     */
    @Test
    public void testGetCurrentSpeed() {
        System.out.println("getCurrentSpeed");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.getCurrentSpeed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentSpeed method, of class PacmanService.
     */
    @Test
    public void testSetCurrentSpeed() {
        System.out.println("setCurrentSpeed");
        int currentSpeed = 0;
        PacmanService instance = new PacmanService();
        instance.setCurrentSpeed(currentSpeed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScreenData method, of class PacmanService.
     */
    @Test
    public void testGetScreenData() {
        System.out.println("getScreenData");
        PacmanService instance = new PacmanService();
        short[] expResult = null;
        short[] result = instance.getScreenData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScreenData method, of class PacmanService.
     */
    @Test
    public void testSetScreenData() {
        System.out.println("setScreenData");
        short[] screenData = null;
        PacmanService instance = new PacmanService();
        instance.setScreenData(screenData);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inGame method, of class PacmanService.
     */
    @Test
    public void testInGame() {
        System.out.println("inGame");
        boolean inGame = false;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.inGame(inGame);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dying method, of class PacmanService.
     */
    @Test
    public void testDying() {
        System.out.println("dying");
        boolean dying = false;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.dying(dying);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of N_GHOSTS method, of class PacmanService.
     */
    @Test
    public void testN_GHOSTS() {
        System.out.println("N_GHOSTS");
        int N_GHOSTS = 0;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.N_GHOSTS(N_GHOSTS);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lives method, of class PacmanService.
     */
    @Test
    public void testLives() {
        System.out.println("lives");
        int lives = 0;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.lives(lives);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of score method, of class PacmanService.
     */
    @Test
    public void testScore() {
        System.out.println("score");
        int score = 0;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.score(score);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dx method, of class PacmanService.
     */
    @Test
    public void testDx() {
        System.out.println("dx");
        int[] dx = null;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.dx(dx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dy method, of class PacmanService.
     */
    @Test
    public void testDy() {
        System.out.println("dy");
        int[] dy = null;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.dy(dy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ghosts method, of class PacmanService.
     */
    @Test
    public void testGhosts() {
        System.out.println("ghosts");
        Ghost[] ghosts = null;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.ghosts(ghosts);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pacman method, of class PacmanService.
     */
    @Test
    public void testPacman() {
        System.out.println("pacman");
        Pacman pacman = null;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.pacman(pacman);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of req_dx method, of class PacmanService.
     */
    @Test
    public void testReq_dx() {
        System.out.println("req_dx");
        int req_dx = 0;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.req_dx(req_dx);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of req_dy method, of class PacmanService.
     */
    @Test
    public void testReq_dy() {
        System.out.println("req_dy");
        int req_dy = 0;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.req_dy(req_dy);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of level method, of class PacmanService.
     */
    @Test
    public void testLevel() {
        System.out.println("level");
        Level level = null;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.level(level);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentSpeed method, of class PacmanService.
     */
    @Test
    public void testCurrentSpeed() {
        System.out.println("currentSpeed");
        int currentSpeed = 0;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.currentSpeed(currentSpeed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of screenData method, of class PacmanService.
     */
    @Test
    public void testScreenData() {
        System.out.println("screenData");
        short[] screenData = null;
        PacmanService instance = new PacmanService();
        PacmanService expResult = null;
        PacmanService result = instance.screenData(screenData);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class PacmanService.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        PacmanService instance = new PacmanService();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class PacmanService.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        PacmanService instance = new PacmanService();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
