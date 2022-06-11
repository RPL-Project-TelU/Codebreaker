package pacman.services;

import java.util.Objects;

import pacman.models.Ghost;
import pacman.models.Level;
import pacman.models.Pacman;

public class PacmanService {
    private boolean inGame = false;
    private boolean dying = false;

    private final int MAX_GHOSTS = 12;
    private final int PACMAN_SPEED = 6;

    private int N_GHOSTS = 6;
    private int lives, score;
    private int[] dx, dy;
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


    public PacmanService(boolean inGame, boolean dying, int N_GHOSTS, int lives, int score, int[] dx, int[] dy, Ghost[] ghosts, Pacman pacman, int req_dx, int req_dy, Level level, int currentSpeed, short[] screenData) {
        this.inGame = inGame;
        this.dying = dying;
        this.N_GHOSTS = N_GHOSTS;
        this.lives = lives;
        this.score = score;
        this.dx = dx;
        this.dy = dy;
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
        return this.dx;
    }

    public void setDx(int[] dx) {
        this.dx = dx;
    }

    public int[] getDy() {
        return this.dy;
    }

    public void setDy(int[] dy) {
        this.dy = dy;
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
        return Objects.hash(inGame, dying, MAX_GHOSTS, PACMAN_SPEED, N_GHOSTS, lives, score, dx, dy, ghosts, pacman, req_dx, req_dy, level, validSpeeds, maxSpeed, currentSpeed, screenData);
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
