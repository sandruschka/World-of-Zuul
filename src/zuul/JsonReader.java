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
 *
 * @author sandra
 */
public class JsonReader {

    private String file;
    private JSONObject jSONObject;
    
    public JsonReader(String file) {
        setFile(file);
    }
    
    public void setFile(String file) {
        this.file = file;
        JSONParser jsonParser = new JSONParser();
        try {
            jSONObject = (JSONObject)jsonParser.parse(new FileReader(file));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JsonReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFieldText(String key) {
        
       String result = "";
       result = (String)jSONObject.get(key); 
       return result;
    }
}
