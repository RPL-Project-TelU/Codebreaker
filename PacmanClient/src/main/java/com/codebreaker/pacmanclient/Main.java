package com.codebreaker.pacmanclient;

import com.codebreaker.pacmanclient.controllers.PacmanController;
import com.codebreaker.pacmanclient.views.MainView;
import java.io.FileNotFoundException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {
        try {
            // Pilih theme yang mau dipakai, uncomment salah satu line dibawah untuk
            // melihat theme berubah
            
            //UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
            //UIManager.setLookAndFeel("com.formdev.flatlaf.FlatIntelliJLaf");
            //UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarculaLaf");
            UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf");

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            System.out.println(ex);
        }
        
        PacmanController controller;
        try {
            controller = new PacmanController();
            MainView view = new MainView(controller);
            view.setTitle("JPacman");
            view.setVisible(true);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        

    }
}
