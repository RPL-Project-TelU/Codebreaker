package pacman.views;

import java.awt.Dimension;
import java.awt.Font;
import java.io.*;

public class ScreenSettings implements Serializable{
    public static int BLOCK_SIZE = 24;
    public static int N_BLOCKS = 15;
    public static int SCREEN_SIZE = N_BLOCKS * BLOCK_SIZE;

    public static Dimension d = new Dimension(400, 400);
    public static final Font smallFont = new Font("Arial", Font.BOLD, 14);

    public static void save(){
        try {
            FileOutputStream fos=new FileOutputStream("settings.json");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            ScreenSettings temp = new ScreenSettings();
            oos.writeObject(temp);
            oos.flush();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void load(){
        try {
            FileInputStream fis =new FileInputStream("settings.json");
            ObjectInputStream ois=new ObjectInputStream(fis);
            ScreenSettings settings = (ScreenSettings) ois.readObject();
        } catch(IOException ioe){
            System.out.println(ioe.getMessage());
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
