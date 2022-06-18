package pacman;

import pacman.controllers.PacmanController;
import pacman.views.MainView;

public class Main {
    public static void main(String[] args) {
        // PacmanController mainController = new PacmanController();
        PacmanController controller = new PacmanController();
        MainView view = new MainView(controller);
        view.setTitle("JPacman");
        view.setVisible(true);

    }
}
