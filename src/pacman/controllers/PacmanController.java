package pacman.controllers;

import pacman.services.PacmanService;
import pacman.views.PacmanView;

public class PacmanController {
    private PacmanService service;
    private PacmanView view;

    public PacmanController(){
        service = new PacmanService();
        view = new PacmanView(this);
    }

    public boolean isDying(){
        return service.isDying();
    }

    public int getScore(){
        return service.getScore();
    }

    public int getLives(){
        return service.getLives();
    }

    public void addScore(int add){
        service.setScore(service.getScore()+add);
    }

    public int getN_GHOSTS(){
        return service.getN_GHOSTS();
    }

    public void addN_GHOSTS(int add){
        service.setN_GHOSTS(service.getN_GHOSTS()+add);
    }

    public int getMAX_GHOSTS(){
        return service.getMAX_GHOSTS(); 
    }

    public int getCurrentSpeed(){
        return service.getCurrentSpeed();
    }

    public void addCurrentSpeed(int add){
        service.setCurrentSpeed(service.getCurrentSpeed()+add);
    }

    public int getMaxSpeed(){
        return service.getMaxSpeed(); 
    }

    public void decreaseHealth(){
        service.decreaseHealt();
    }
}
