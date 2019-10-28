/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * The class reads from a JSON file
 * @author sandra
 */
public class JsonReader {

    private JSONObject jSONObject;
    
    /**
     * 
     * @param file  the language file containing the game output
     */
    public JsonReader(String file) {
        setFile(file);
    }
    
    /**
     *
     * @param file  e.g "src/Languages/English.json"
     */
    public final void setFile(String file) {
        JSONParser jsonParser = new JSONParser();
        try {
            jSONObject = (JSONObject)jsonParser.parse(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ParseException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param key   the JSON key to retrieve the desired text
     * @return  the text as a String
     */
    public String getFieldText(String key) {
       return (String)jSONObject.get(key); 
    }
}
