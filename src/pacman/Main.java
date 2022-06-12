package pacman;

import pacman.controllers.PacmanController;
import pacman.models.Level;
import pacman.views.ScreenSettings;

public class Main {
    public static void main(String[] args){
        //PacmanController mainController = new PacmanController();
        Level test1 = new Level();
        test1.save();
        ScreenSettings test2 = new ScreenSettings();
        ScreenSettings.save();
        System.out.println(test1);
        System.out.println(test2);
        
        for(int b : Level.levels[0]){
            System.out.println((short) b);
        }
        
    }
}
