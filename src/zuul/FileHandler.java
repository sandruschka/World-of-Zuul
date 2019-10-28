/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zuul;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Managing files and packages
 * @author sandra
 */
public class FileHandler {
   
    /**
     * Finds all the class names from a package
     * @param packageName
     * @return a list containing each name as a String
     */
    
    
    public List<String> getClassesFromPackage(String packageName) {
        List<String> classes = new ArrayList<>();
        try {
            File directory = getPackageDirectory(packageName);
            
            for (String filename : directory.list())
                classes.add(filename);
            
        } catch(NullPointerException e) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return classes;
    }
    
    /**
     * 
     * @param packageName
     * @return the File object of the directory
     * @throws NullPointerException 
     */
    private File getPackageDirectory(String packageName) throws NullPointerException {
        
        ClassLoader cld = Thread.currentThread().getContextClassLoader();
       
        if (cld == null) 
            throw new NullPointerException("ClassLoader not found");
 
        URL resource = cld.getResource(packageName.replace('.', '/')); //get path to the directory
        
        if (resource == null)
            throw new NullPointerException("Resource not found");
        
        return new File(resource.getFile());
    }
}
