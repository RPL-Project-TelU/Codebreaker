package pacman.controllers;

import pacman.services.PacmanService;
import pacman.views.PacmanView;

public class PacmanController {
    private PacmanService service;

    public PacmanController() {
        service = new PacmanService();
        new PacmanView(this);
    }

    public void run() {

    }

    public void movePacman() {
        service.movePacman();
    }

    public void moveGhosts() {
        service.moveGhosts();
    }

    public int getReq_dx() {
        return service.getReq_dx();
    }

    public int getReq_dy() {
        return service.getReq_dy();
    }

    public int getPacmanX() {
        return service.getPacman().getX();
    }

    public int getPacmanY() {
        return service.getPacman().getY();
    }

    public void initGame() {
        service.initGame();
    }

    public void initLevel() {
        service.initLevel();
    }

    public short[] getScreenData() {
        return service.getScreenData();
    }

    public void continueLevel() {
        service.continueLevel();
    }

    public void setReqDxReqDy(int dx, int dy) {
        service.setReq_dx(dx);
        service.setReq_dy(dy);
    }

    public void setInGame(boolean inGame) {
        service.setInGame(inGame);
    }

    public boolean isInGame() {
        return service.isInGame();
    }

    public boolean isDying() {
        return service.isDying();
    }

    public void setDying(boolean dying) {
        service.setDying(dying);
    }

    public int getScore() {
        return service.getScore();
    }

    public int getLives() {
        return service.getLives();
    }

    public void addScore(int add) {
        service.setScore(service.getScore() + add);
    }

    public int getN_GHOSTS() {
        return service.getN_GHOSTS();
    }

    public void addN_GHOSTS(int add) {
        service.setN_GHOSTS(service.getN_GHOSTS() + add);
    }

    public int getMAX_GHOSTS() {
        return service.getMAX_GHOSTS();
    }

    public int getCurrentSpeed() {
        return service.getCurrentSpeed();
    }

    public void addCurrentSpeed(int add) {
        service.setCurrentSpeed(service.getCurrentSpeed() + add);
    }

    public int getMaxSpeed() {
        return service.getMaxSpeed();
    }

    public void decreaseHealth() {
        service.decreaseHealt();
    }

    public int getGhostX(int i) {
        return service.getGhosts()[i].getX();
    }

    public int getGhostY(int i) {
        return service.getGhosts()[i].getY();
    }

}
