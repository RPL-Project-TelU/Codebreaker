/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author acer
 */
enum GameState {
    NotPlayed,
    IsPlayed
}
enum EntityState {
    Alive,
    Dead
}


public class Model extends JPanel implements ActionListener{

    //Attributes
    //General Attribute
    private Dimension d;
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private GameState inGame = GameState.NotPlayed;
    private EntityState dying = EntityState.Alive;
    private final int BLOCK_SIZE = 24;
    private final int N_BLOCKS = 15;
    private final int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;
    
    //Game config attribut(s)
    Config<Integer> CONFIG = new Config<>(24,15,12,6);
    
        
    //Assets attributes
    private Image heart, ghost;
    private Image up, down, left, right;
    
    //current game attributes
    private int N_GHOSTS;
    private int lives, score;
    private int [] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;
    
    private int pacman_x, pacman_y, pacmand_x, pacmand_y;  
    private int req_dx, req_dy;
    
    private final int[] validSpeeds = {1,2,3,4,6,8};
    private final int maxSpeed = 6; // general max speed
    private int currentSpeed = 3;
    private short [] screenData;
    private Timer timer;
    
    private final short[] level = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28
    };
    
    public Model(){
        loadImage();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }

    private void loadImage(){
        //Precondition assets files exist
        try {
            assert new File("src/assets/").exists();
            assert new File("src/assets/hearth.png").exists();
            assert new File("src/assets/ghost.png").exists();
            assert new File("src/assets/up.gif").exists();
            assert new File("src/assets/down.gif").exists();
            assert new File("src/assets/left.gif").exists();
            assert new File("src/assets/right.gif").exists();
        } catch (Exception ex){
            //throw exception saja biar ngebrick, kalo gak gambarnya gak ada
            throw ex;
        } finally {
            heart = new ImageIcon("src/assets/hearth.png").getImage();
            ghost = new ImageIcon("src/assets/ghost.png").getImage();
            up = new ImageIcon("src/assets/up.gif").getImage();
            down = new ImageIcon("src/assets/down.gif").getImage();
            left = new ImageIcon("src/assets/left.gif").getImage();
            right = new ImageIcon("src/assets/right.gif").getImage();
        }
    }

    private void initVariables(){
        screenData = new short[CONFIG.getN_BLOCKS() * CONFIG.getN_BLOCKS()];
        d = new Dimension(400, 400);
        ghost_x = new int[CONFIG.getMAX_GHOST()];
        ghost_dx = new int[CONFIG.getMAX_GHOST()];
        ghost_y = new int[CONFIG.getMAX_GHOST()];
        ghost_dy = new int[CONFIG.getMAX_GHOST()];
        ghostSpeed = new int[CONFIG.getMAX_GHOST()];
        dx = new int[4];
        dy = new int[4];
        
        timer = new Timer(1000, this);
        timer.start();
    }
    
    private void initGame(){
        lives = 3;
        score = 0;
        initLevel();
        N_GHOSTS = 6;
        currentSpeed = 3;
    }

    private void initLevel() {
        for (int i = 0; i < CONFIG.getN_BLOCKS() * CONFIG.getN_BLOCKS(); i++) {
            screenData[i] = level[i];
        }

        continueLevel();
    }



    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.BLACK);
        g2d.fillRect(0, 0, (int)d.getWidth(), (int)d.getHeight());
    }

    private void drawMaze(Graphics2D g2d){

        short i = 0;
        int x, y;

        for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
            for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                g2d.setColor(new Color(0,72,100));
                g2d.setStroke(new BasicStroke(5));
                
                if ((level[i] == 0)) { 
                	g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                 }

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1,
                            y + BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillOval(x + 10, y + 10, 6, 6);
               }

                i++;
            }
        }
    }

             
        private void drawScore(Graphics2D g) {
                g.setFont(smallFont);
                g.setColor(new Color(5, 181, 79));
                String s = "Score: " + score;
                g.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

                for (int i = 0; i < lives; i++) {
                    g.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
                }
            }

        if( inGame == GameState.IsPlayed){
            //TODO playGame(g2d);
        } else {
            //TODO showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    }

    private void continueLevel(){
        int dx = 1;
        int random;
        for (int i = 0; i < N_GHOSTS; i++){
            ghost_x[i] = 4*CONFIG.getBLOCK_SIZE();
            ghost_y[i] = 4*CONFIG.getBLOCK_SIZE();
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghostSpeed[i] = validSpeeds[random];
        
        }

        pacman_x = 7 * CONFIG.getBLOCK_SIZE();
        pacman_y = 11 * CONFIG.getBLOCK_SIZE();
        pacmand_x = 0;
        pacmand_y = 0;
        req_dx = 0;
        req_dy = 0;
        dying = EntityState.Alive;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // extends KeyAdapter to listen every keyboard events
    class TAdapter extends KeyAdapter {
        // TODO: define Map<Integer, Runnable> variable to implement table driven
        /*
        // Runnable is lambda function
        * KeyEvent.VK_DOWN : () -> {
                req_dx = 0;
                req_dy = 1;
            }
        * */
        private final Map<Integer, Runnable> movements = new HashMap<>();

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            Runnable button = movements.get(key);

            if (inGame == GameState.IsPlayed && button != null) {
                // call lambda function (Runnable)
                button.run();
            } else if (inGame == GameState.NotPlayed) {
                button.run();
            }
        }

        // table driven
        private void movementsMapping() {
            movements.put(KeyEvent.VK_UP, () -> {
                req_dx = 0;
                req_dy = -1;
            });

            movements.put(KeyEvent.VK_DOWN, () -> {
                req_dx = 0;
                req_dy = 1;
            });

            movements.put(KeyEvent.VK_LEFT, () -> {
                req_dx = -1;
                req_dy = 0;
            });

            movements.put(KeyEvent.VK_RIGHT, () -> {
                req_dx = 1;
                req_dy = 0;
            });

            movements.put(KeyEvent.VK_ESCAPE, () -> inGame = GameState.NotPlayed);

            movements.put(KeyEvent.VK_SPACE, () -> {
                inGame = GameState.IsPlayed;
                initGame();
            });
        }
    }
    
}
