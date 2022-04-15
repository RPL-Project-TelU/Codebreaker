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
        assert new File("/assets/").exists();
        assert new File("/assets/hearth.png").exists();
        assert new File("/assets/ghost.png").exists();
        assert new File("/assets/up.gif").exists();
        assert new File("/assets/down.gif").exists();
        assert new File("/assets/left.gif").exists();
        assert new File("/assets/right.gif").exists();

        heart = new ImageIcon("/assets/hearth.png").getImage();
        ghost = new ImageIcon("/assets/ghost.png").getImage();
        up = new ImageIcon("/assets/up.gif").getImage();
        down = new ImageIcon("/assets/down.gif").getImage();
        left = new ImageIcon("/assets/left.gif").getImage();
        right = new ImageIcon("/assets/right.gif").getImage();
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

        //TODO drawMaze(g2d);
        //TODO drawScore(g2d);

        if( inGame == GameState.IsPlayed){
            //TODO playGame(g2d);
        } else {
            //TODO showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();

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

    class TAdapter extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int key = e.getKeyCode();

            if ( inGame == GameState.IsPlayed){
                switch (key){
                    case (KeyEvent.VK_UP):
                        req_dx = 0;
                        req_dy = -1;
                        break;
                    case (KeyEvent.VK_DOWN):
                        req_dx = 0;
                        req_dy = 1;
                        break;
                    case (KeyEvent.VK_LEFT):
                        req_dx = -1;
                        req_dy = 0;
                        break;
                    case (KeyEvent.VK_RIGHT):
                        req_dx = 1;
                        req_dy = 0;
                        break;
                    case (KeyEvent.VK_ESCAPE):
                        if (timer.isRunning()){
                            inGame = GameState.NotPlayed;
                        }
                }
            } else if (inGame == GameState.NotPlayed ){
                if (key == KeyEvent.VK_SPACE){
                    inGame = GameState.IsPlayed;
                    initGame();
                }
            }
        }
    
    }
    
}
