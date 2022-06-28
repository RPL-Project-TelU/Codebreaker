package com.codebreaker.pacmanclient;

import com.codebreaker.pacmanclient.controllers.PacmanController;
import com.codebreaker.pacmanclient.views.MainView;

public class Main {
    public static void main(String[] args) {
        // PacmanController mainController = new PacmanController();
        PacmanController controller = new PacmanController();
        MainView view = new MainView(controller);
        view.setTitle("JPacman");
        view.setVisible(true);

    }
}
