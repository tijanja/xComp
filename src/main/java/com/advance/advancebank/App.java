package com.advance.advancebank;

import org.jivesoftware.whack.ExternalComponentManager;
import org.xmpp.component.ComponentException;

/**
 *
 * @author tunjiakinde
 */

public class App {
    
    public static void main(String[] args) {
       
        final ExternalComponentManager manager;
        manager = new ExternalComponentManager("35.226.220.222", 5275,false);
        
        manager.setSecretKey("advancetest", "Project123");
       
        manager.setMultipleAllowed("advancetest", true);
        try {
            
            manager.addComponent("advancetest", new AdvanceComponent());
            //manager.addComponent("advancebank", new AdvanceAbstract());
            
            while (true) {
                try {
                    Thread.sleep(1000);
                     System.out.println("server active...");
                } catch (InterruptedException e) {
                    System.out.println("loop-error:"+e.getMessage());
                }
            }
        } catch (ComponentException e) {
            System.out.println("component-manager-error:"+e.getMessage());
        }
    }
}
