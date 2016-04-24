/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingyfier;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Martin
 */
public interface ISwingyfier extends Remote{
    
    public enum topic{ZOOMOUT_GAME}
    
    public void gaet(String guess) throws RemoteException;
    public boolean subscribe(topic t, String username) throws RemoteException;
    public void addPic(String url, String answer, String category);
    
}
