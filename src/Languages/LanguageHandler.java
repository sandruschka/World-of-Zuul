/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Languages;

import zuul.JsonReader;
import java.util.List;
import zuul.FileHandler;

/**
 *
 * @author sandra
 */
public final class LanguageHandler {

    private String languageFile;
    private JsonReader jsonReader;

    
    public LanguageHandler(String language) {
        setLanguage(language);
    }
    
    public void setLanguage(String language) {
        FileHandler fileHandler = new FileHandler();

        List<String> classes = fileHandler.getClassesFromPackage("Languages");
        
        String file = language.substring(0, 1).toUpperCase() + language.substring(1) + ".json";
        if (classes.stream().anyMatch(s -> s.equalsIgnoreCase(file))) {
            languageFile = file;
            jsonReader = new JsonReader("src/Languages/" + languageFile);
        }
    
    }
    
    public String getText(String key) {
        return jsonReader.getFieldText(key);
    }
}
