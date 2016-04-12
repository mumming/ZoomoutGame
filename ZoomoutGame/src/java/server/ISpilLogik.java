/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

/**
 *
 * @author Martin
 */
public interface ISpilLogik {
    public boolean modtagGaet(String navn, String gaet);
    public boolean registrerBruger(String navn);
    public void hentSpildata();
}
