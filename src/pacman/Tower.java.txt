/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 *
 * @author acer
 */



public class Tower {
    //parsing
    public static void parsing(){
        ClassLoader classLoader = new Tower().getClass().getClassLoader();
        String fileName = "src/level.json";
        File file = new File(classLoader.getResource(fileName).getFile());

        JSONParser parser = new JSONParser();

        try{
                FileReader reader = new FileReader(file.getAbsolutePath());
                Object obj = parser.parse(reader);
                JSONObject jsonObj = (JSONObject) obj;
                JSONArray level = (JSONArray) jsonObj.get("level");  
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void init(){
        
    }
    
}
