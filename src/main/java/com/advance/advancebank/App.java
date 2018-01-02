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
        manager = new ExternalComponentManager("******", 5275,false);
        
        manager.setSecretKey("******", "******");
       
        manager.setMultipleAllowed("******", true);
        try {
            
            manager.addComponent("********", new AdvanceComponent());
            //manager.addComponent("*******", new AdvanceAbstract());
            
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
