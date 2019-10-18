/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sandra
 */
public class FileHandler {
   
    public FileHandler() {
        
    }
    
    public List<String> getClassesFromPackage(String packageName) {
        List<String> classes = new ArrayList<>();
        
        File directory = getPackageDirectory(packageName);
        
         for (String filename : directory.list()) {
            classes.add(filename);
        }
        System.out.println(classes);
        return classes;
    }
    
    private String buildClassname(String packageName, String filename) {
        return packageName + '.' + filename.replace(".class", "");
    }
    
    private File getPackageDirectory(String packageName) {
        ClassLoader cld = Thread.currentThread().getContextClassLoader();
       
        if (cld == null) 
            return null;
 
        URL resource = cld.getResource(packageName.replace('.', '/'));
        
        if (resource == null) {
            return null;
        }
        
        return new File(resource.getFile());
    }
}
