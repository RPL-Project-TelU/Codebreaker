package pacman.services;

import java.util.Objects;

import pacman.models.Ghost;
import pacman.models.Level;
import pacman.models.Pacman;
import pacman.views.ScreenSettings;

public class PacmanService {
    private boolean inGame = false;
    private boolean dying = false;

    private final int MAX_GHOSTS = 12;
    private final int PACMAN_SPEED = 6;

    private int N_GHOSTS = 6;
    private int lives, score;
    private int[] g_req_dx, g_req_dy;
    private Ghost[] ghosts;

    private Pacman pacman;
    private int req_dx, req_dy;

    private Level level;

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private final int maxSpeed = 6;

    private int currentSpeed = 3;
    private short[] screenData;

    public PacmanService(){
        ghosts = new Ghost[MAX_GHOSTS]; 
        for (Ghost g : ghosts){
            g = new Ghost();
        }
        g_req_dx = new int[4];
        g_req_dy = new int[4];
        pacman = new Pacman();
    }

    public boolean isDying(){
        return dying;
    }

    public void decreaseHealt(){
        lives--;

        if(lives == 0){
            inGame = false;
            
        }
    }

    public void initGame(){
        lives = 3;
        score = 0;
        N_GHOSTS = 6;
        currentSpeed = 3;
    }

    public int getScore(){
        return score;
    }

    public void movePacman() {

        int pos;
        short ch;

        if (pacman.getX() % ScreenSettings.BLOCK_SIZE == 0 && pacman.getY() % ScreenSettings.BLOCK_SIZE == 0) {
            // Get block posision representation in array
            pos = pacman.getX() / ScreenSettings.BLOCK_SIZE + 
                ScreenSettings.N_BLOCKS * (int) (pacman.getY() / ScreenSettings.BLOCK_SIZE);
            ch = screenData[pos];

            if ((ch & 16) != 0) {
                screenData[pos] = (short) (ch & 15);
                score++;
            }

            if (req_dx != 0 || req_dy != 0) {
                if (!((req_dx == -1 && req_dy == 0 && (ch & 1) != 0)
                        || (req_dx == 1 && req_dy == 0 && (ch & 4) != 0)
                        || (req_dx == 0 && req_dy == -1 && (ch & 2) != 0)
                        || (req_dx == 0 && req_dy == 1 && (ch & 8) != 0))) {
                    pacman.setDx(req_dx);
                    pacman.setDy(req_dy);
                }
            }

            // Check for standstill
            if ((pacman.getDx() == -1 && pacman.getDy() == 0 && (ch & 1) != 0)
                    || (pacman.getDx() == 1 && pacman.getDy() == 0 && (ch & 4) != 0)
                    || (pacman.getDx() == 0 && pacman.getDy() == -1 && (ch & 2) != 0)
                    || (pacman.getDx() == 0 && pacman.getDy() == 1 && (ch & 8) != 0)) {
                pacman.setDx(0);
                pacman.setDy(0);
            }
        } 
        pacman.updatePos();
    }

    

    public void moveGhosts() {

        int pos;
        int count;
        // TODO how to implement ghost moving

        // Iterate through all ghost
        for (int i = 0; i < N_GHOSTS; i++) {

            // Check if ghost in a block?
            if (ghosts[i].getX() % ScreenSettings.BLOCK_SIZE == 0 
            && ghosts[i].getY() % ScreenSettings.BLOCK_SIZE == 0) {

                // Get block posision representation in array 
                pos = ghosts[i].getX() / ScreenSettings.BLOCK_SIZE 
                + ScreenSettings.N_BLOCKS * (int) (ghosts[i].getY() / ScreenSettings.BLOCK_SIZE);

                count = 0;

                if ((screenData[pos] & 1) == 0 && ghosts[i].getDx() != 1) {
                    g_req_dx[count] = -1;
                    g_req_dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 2) == 0 && ghosts[i].getDy() != 1) {
                    g_req_dx[count] = 0;
                    g_req_dy[count] = -1;
                    count++;
                }

                if ((screenData[pos] & 4) == 0 && ghosts[i].getDx() != -1) {
                    g_req_dx[count] = 1;
                    g_req_dy[count] = 0;
                    count++;
                }

                if ((screenData[pos] & 8) == 0 && ghosts[i].getDy() != -1) {
                    g_req_dx[count] = 0;
                    g_req_dy[count] = 1;
                    count++;
                }

                if (count == 0) {

                    if ((screenData[pos] & 15) == 15) {
                        ghosts[i].setDx(0);
                        ghosts[i].setDy(0);
                    } else {
                        ghosts[i].setDx(-ghosts[i].getDx());
                        ghosts[i].setDy(-ghosts[i].getDy());
                    }

                } else {

                    count = (int) (Math.random() * count);

                    if (count > 3) {
                        count = 3;
                    }

                    ghosts[i].setDx(g_req_dx[count]);
                    ghosts[i].setDy(g_req_dy[count]);

                }

            }

            ghosts[i].updatePos();
            //drawGhost(g2d, ghost_x[i] + 1, ghost_y[i] + 1);

            if (pacman.getX() > (ghosts[i].getX() - 12) && pacman.getX() < (ghosts[i].getX() + 12)
                    && pacman.getY() > (ghosts[i].getY() - 12) && pacman.getY() < (ghosts[i].getY() + 12)
                    && inGame) {

                    dying =true;
            }
        }
    }

    public void continueLevel() {

    	int dx = 1;
        int random;

        for (int i = 0; i < N_GHOSTS; i++) {

            ghosts[i].setY(4 * ScreenSettings.BLOCK_SIZE); //start position
            ghosts[i].setX(4 * ScreenSettings.BLOCK_SIZE);
            ghosts[i].setDy(0);
            ghosts[i].setDx(dx);
            dx = -dx;
            random = (int) (Math.random() * (currentSpeed + 1));

            if (random > currentSpeed) {
                random = currentSpeed;
            }

            ghosts[i].setSpeed(validSpeeds[random]);
        }

        
        pacman.setY(7 * ScreenSettings.BLOCK_SIZE); //start position
        pacman.setX(11 * ScreenSettings.BLOCK_SIZE);
        pacman.setDy(0);    //reset direction move
        pacman.setDx(0);
        req_dx = 0;		// reset direction controls
        req_dy = 0;
        dying = false;
    }

    public PacmanService(boolean inGame, boolean dying, int N_GHOSTS, int lives, int score, int[] dx, int[] dy, Ghost[] ghosts, Pacman pacman, int req_dx, int req_dy, Level level, int currentSpeed, short[] screenData) {
        this.inGame = inGame;
        this.dying = dying;
        this.N_GHOSTS = N_GHOSTS;
        this.lives = lives;
        this.score = score;
        this.g_req_dx = dx;
        this.g_req_dy = dy;
        this.ghosts = ghosts;
        this.pacman = pacman;
        this.req_dx = req_dx;
        this.req_dy = req_dy;
        this.level = level;
        this.currentSpeed = currentSpeed;
        this.screenData = screenData;
    }

    public boolean isInGame() {
        return this.inGame;
    }

    public boolean getInGame() {
        return this.inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public boolean getDying() {
        return this.dying;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }

    public int getMAX_GHOSTS() {
        return this.MAX_GHOSTS;
    }


    public int getPACMAN_SPEED() {
        return this.PACMAN_SPEED;
    }


    public int getN_GHOSTS() {
        return this.N_GHOSTS;
    }

    public void setN_GHOSTS(int N_GHOSTS) {
        this.N_GHOSTS = N_GHOSTS;
    }

    public int getLives() {
        return this.lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
    public void setScore(int score) {
        this.score = score;
    }

    public int[] getDx() {
        return this.g_req_dx;
    }

    public void setDx(int[] dx) {
        this.g_req_dx = dx;
    }

    public int[] getDy() {
        return this.g_req_dy;
    }

    public void setDy(int[] dy) {
        this.g_req_dy = dy;
    }

    public Ghost[] getGhosts() {
        return this.ghosts;
    }

    public void setGhosts(Ghost[] ghosts) {
        this.ghosts = ghosts;
    }

    public Pacman getPacman() {
        return this.pacman;
    }

    public void setPacman(Pacman pacman) {
        this.pacman = pacman;
    }

    public int getReq_dx() {
        return this.req_dx;
    }

    public void setReq_dx(int req_dx) {
        this.req_dx = req_dx;
    }

    public int getReq_dy() {
        return this.req_dy;
    }

    public void setReq_dy(int req_dy) {
        this.req_dy = req_dy;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int[] getValidSpeeds() {
        return this.validSpeeds;
    }


    public int getMaxSpeed() {
        return this.maxSpeed;
    }


    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public short[] getScreenData() {
        return this.screenData;
    }

    public void setScreenData(short[] screenData) {
        this.screenData = screenData;
    }

    public PacmanService inGame(boolean inGame) {
        setInGame(inGame);
        return this;
    }

    public PacmanService dying(boolean dying) {
        setDying(dying);
        return this;
    }

    public PacmanService N_GHOSTS(int N_GHOSTS) {
        setN_GHOSTS(N_GHOSTS);
        return this;
    }

    public PacmanService lives(int lives) {
        setLives(lives);
        return this;
    }

    public PacmanService score(int score) {
        setScore(score);
        return this;
    }

    public PacmanService dx(int[] dx) {
        setDx(dx);
        return this;
    }

    public PacmanService dy(int[] dy) {
        setDy(dy);
        return this;
    }

    public PacmanService ghosts(Ghost[] ghosts) {
        setGhosts(ghosts);
        return this;
    }

    public PacmanService pacman(Pacman pacman) {
        setPacman(pacman);
        return this;
    }

    public PacmanService req_dx(int req_dx) {
        setReq_dx(req_dx);
        return this;
    }

    public PacmanService req_dy(int req_dy) {
        setReq_dy(req_dy);
        return this;
    }

    public PacmanService level(Level level) {
        setLevel(level);
        return this;
    }

    public PacmanService currentSpeed(int currentSpeed) {
        setCurrentSpeed(currentSpeed);
        return this;
    }

    public PacmanService screenData(short[] screenData) {
        setScreenData(screenData);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inGame, dying, MAX_GHOSTS, PACMAN_SPEED, N_GHOSTS, lives, score, g_req_dx, g_req_dy, ghosts, pacman, req_dx, req_dy, level, validSpeeds, maxSpeed, currentSpeed, screenData);
    }

    @Override
    public String toString() {
        return "{" +
            " inGame='" + isInGame() + "'" +
            ", dying='" + isDying() + "'" +
            ", MAX_GHOSTS='" + getMAX_GHOSTS() + "'" +
            ", PACMAN_SPEED='" + getPACMAN_SPEED() + "'" +
            ", N_GHOSTS='" + getN_GHOSTS() + "'" +
            ", lives='" + getLives() + "'" +
            ", score='" + getScore() + "'" +
            ", dx='" + getDx() + "'" +
            ", dy='" + getDy() + "'" +
            ", ghosts='" + getGhosts() + "'" +
            ", pacman='" + getPacman() + "'" +
            ", req_dx='" + getReq_dx() + "'" +
            ", req_dy='" + getReq_dy() + "'" +
            ", level='" + getLevel() + "'" +
            ", validSpeeds[]='" + getValidSpeeds().toString() + "'" +
            ", maxSpeed='" + getMaxSpeed() + "'" +
            ", currentSpeed='" + getCurrentSpeed() + "'" +
            ", screenData='" + getScreenData() + "'" +
            "}";
    }
    
}
