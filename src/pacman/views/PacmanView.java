package pacman.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import pacman.controllers.PacmanController;
import pacman.models.*;

public class PacmanView extends JPanel implements ActionListener{
    //mvc stuff
    private PacmanController ctrl;
    
    private Image heart;

    private short[] screenData;
    private Timer timer;

    public PacmanView(PacmanController ctrl) {
        this.ctrl = ctrl;
        loadImages();
        initVariables();
        addKeyListener(new TAdapter());
        setFocusable(true);
        initGame();
    }
    
    
    private void loadImages() {
    	Pacman.down = new ImageIcon("/src/images/down.gif").getImage();
    	Pacman.up = new ImageIcon("/src/images/up.gif").getImage();
    	Pacman.left = new ImageIcon("/src/images/left.gif").getImage();
    	Pacman.right = new ImageIcon("/src/images/right.gif").getImage();
        Ghost.image = new ImageIcon("/src/images/ghost.gif").getImage();
        heart = new ImageIcon("/src/images/heart.png").getImage();

    }
       private void initVariables() {
        screenData = new short[ScreenSettings.N_BLOCKS * ScreenSettings.N_BLOCKS];
        ScreenSettings.load();

        timer = new Timer(40, this);
        timer.start();
    }

    private void playGame(Graphics2D g2d) {

        if (ctrl.isDying()) {
            ctrl.decreaseHealth();
            ctrl.continueLevel();
            
        } else {
            ctrl.movePacman();
            drawPacman(g2d);
            ctrl.moveGhosts();
            drawGhosts(g2d);
            checkMaze();
        }
    }

    private void showIntroScreen(Graphics2D g2d) {
 
    	String start = "Press SPACE to start";
        g2d.setColor(Color.yellow);
        g2d.drawString(start, (ScreenSettings.SCREEN_SIZE)/4, 150);
    }

    private void drawScore(Graphics2D g) {
        g.setFont(ScreenSettings.smallFont);
        g.setColor(new Color(5, 181, 79));
        String s = "Score: " + ctrl.getScore();
        g.drawString(s, ScreenSettings.SCREEN_SIZE / 2 + 96, ScreenSettings.SCREEN_SIZE + 16);

        for (int i = 0; i < ctrl.getLives(); i++) {
            g.drawImage(heart, i * 28 + 8, ScreenSettings.SCREEN_SIZE + 1, this);
        }
    }

    private void checkMaze() {

        int i = 0;
        boolean finished = true;

        while (i < ScreenSettings.N_BLOCKS * ScreenSettings.N_BLOCKS && finished) {

            if ((screenData[i]) != 0) {
                finished = false;
            }

            i++;
        }

        if (finished) {

            ctrl.addScore(50);

            if (ctrl.getN_GHOSTS() < ctrl.getMAX_GHOSTS()) {
                ctrl.addN_GHOSTS(1);
            }

            if (ctrl.getCurrentSpeed() < ctrl.getMaxSpeed()) {
                ctrl.addCurrentSpeed(1);
            }

            initLevel();
        }
    }



    private void drawGhosts(Graphics2D g2d) {
        // Iterate through all ghost
        for (int i = 0; i < ctrl.getN_GHOSTS(); i++) {
            g2d.drawImage(Ghost.image, ctrl.getGhostX(i) + 1, ctrl.getGhostY(i) + 1, this);
        }
    }

    private void drawPacman(Graphics2D g2d) {

        if (ctrl.getReq_dx() == -1) {
        	g2d.drawImage(Pacman.left, ctrl.getPacmanX() + 1, ctrl.getPacmanY() + 1, this);
        } else if (ctrl.getReq_dx() == 1) {
        	g2d.drawImage(Pacman.right, ctrl.getPacmanX() + 1, ctrl.getPacmanY() + 1, this);
        } else if (ctrl.getReq_dy() == -1) {
        	g2d.drawImage(Pacman.up, ctrl.getPacmanX() + 1, ctrl.getPacmanY() + 1, this);
        } else {
        	g2d.drawImage(Pacman.down, ctrl.getPacmanX() + 1, ctrl.getPacmanY() + 1, this);
        }
    }

    private void drawMaze(Graphics2D g2d) {

        short i = 0;
        int x, y;

        for (y = 0; y < ScreenSettings.SCREEN_SIZE; y += ScreenSettings.BLOCK_SIZE) {
            for (x = 0; x < ScreenSettings.SCREEN_SIZE; x += ScreenSettings.BLOCK_SIZE) {

                g2d.setColor(new Color(0,72,251));
                g2d.setStroke(new BasicStroke(5));
                
                if ((Level.levels[0][i] == 0)) { 
                	g2d.fillRect(x, y, ScreenSettings.BLOCK_SIZE, ScreenSettings.BLOCK_SIZE);
                 }

                if ((screenData[i] & 1) != 0) { 
                    g2d.drawLine(x, y, x, y + ScreenSettings.BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 2) != 0) { 
                    g2d.drawLine(x, y, x + ScreenSettings.BLOCK_SIZE - 1, y);
                }

                if ((screenData[i] & 4) != 0) { 
                    g2d.drawLine(x + ScreenSettings.BLOCK_SIZE - 1, y, x + ScreenSettings.BLOCK_SIZE - 1,
                            y + ScreenSettings.BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 8) != 0) { 
                    g2d.drawLine(x, y + ScreenSettings.BLOCK_SIZE - 1, x + ScreenSettings.BLOCK_SIZE - 1,
                            y + ScreenSettings.BLOCK_SIZE - 1);
                }

                if ((screenData[i] & 16) != 0) { 
                    g2d.setColor(new Color(255,255,255));
                    g2d.fillOval(x + 10, y + 10, 6, 6);
               }

                i++;
            }
        }
    }

    private void initGame() {
    	ctrl.initGame();
        initLevel();
    }

    private void initLevel() {

        int i;
        for (i = 0; i < ScreenSettings.N_BLOCKS * ScreenSettings.N_BLOCKS; i++) {
            screenData[i] = (short) Level.levels[0][1];
        }

        ctrl.continueLevel();
    }

    

 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, ScreenSettings.d.width, ScreenSettings.d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (ctrl.isInGame()) {
            playGame(g2d);
        } else {
            showIntroScreen(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
        g2d.dispose();
    }


    //controls
    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (ctrl.isInGame()) {
                if (key == KeyEvent.VK_LEFT) {
                    ctrl.setReqDxReqDy(-1, 0);
                } else if (key == KeyEvent.VK_RIGHT) {
                    ctrl.setReqDxReqDy(1, 0);
                } else if (key == KeyEvent.VK_UP) {
                    ctrl.setReqDxReqDy(0, -1);
                } else if (key == KeyEvent.VK_DOWN) {
                    ctrl.setReqDxReqDy(0, 1);
                } else if (key == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    ctrl.setInGame(false);
                } 
            } else {
                if (key == KeyEvent.VK_SPACE) {
                    ctrl.setInGame(true);
                    initGame();
                }
            }
        }
}

	
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
		
	
}
