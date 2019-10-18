/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.of.zuul;

import Data.FileHandler;
import java.io.File;
import java.net.URL;

/**
 *
 * @author sandra
 */
public enum ActionType {
    GO, QUIT, HELP, LOOK, TAKE, DROP, GIVE, UNKNOWN;
    
//    public static String getActionsString() {
//        String result = "";
//        for (ActionType a : ActionType.values()) {
//            result += " " + a;
//          }
//        return result;
//    }
    
    public static String getActionsString() {
        
        FileHandler fileHandler = new FileHandler();
        String packageName = "world.of.zuul.Actions";
        String actions = "";
        
        for (String s : fileHandler.getClassesFromPackage(packageName)) {
            actions += " " + s;
        }
        
        return actions.replace(packageName, "").replace("class", "").replace(".", "");
        
    }
    
    private static String buildClassname(String pckgname, String filename) {
        return pckgname + '.' + filename.replace(".class", "");
    }
    
    private static File getPackageDirectory(String pckgname) {
        ClassLoader cld = Thread.currentThread().getContextClassLoader();
       
        if (cld == null) 
            return null;
 
        URL resource = cld.getResource(pckgname.replace('.', '/'));
        if (resource == null) {
            throw new RuntimeException("Package " + pckgname + " not found on classpath.");
        }
 
        return new File(resource.getFile());
    }
}
