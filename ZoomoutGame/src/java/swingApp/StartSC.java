/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package swingApp;

import java.awt.EventQueue;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jboss.weld.Container;
import swingyfier.ISwingyfier;

/**
 * This class establishes the connection to the Swingyfier
 *
 * @author Martin
 */
public class StartSC {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StartSC ss = new StartSC();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        
    }
    
    public StartSC(){
        initialize();
    }
    
    //indkommenter når swingyfier kører
    private void initialize() {
        String userName = null;
        boolean nameAccepted = false;
        MainGUI gui = new MainGUI();
        gui.setVisible(true);/*
        try {
            try {
                ISwingyfier iss = (ISwingyfier) LocateRegistry.getRegistry().lookup("ISwingSwingy");
                while(!nameAccepted){*/
                    userName = JOptionPane.showInputDialog("Indtast brugernavn:");/*
                    nameAccepted = iss.subscribe(ISwingyfier.topic.ZOOMOUT_GAME, userName);
                }
            } catch (RemoteException ex) {
                Logger.getLogger(StartSC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NotBoundException ex) {
            Logger.getLogger(StartSC.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        
        
        
        
    }
}
