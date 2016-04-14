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
public class Spiller {
    private String navn;
    private int points;
    private boolean harSvaretRigtigt;
    
    public Spiller(String navn){
        this.navn = navn;
        this.points = 0;
        this.harSvaretRigtigt = false;
    }

    /**
     * @return the navn
     */
    public String getNavn() {
        return navn;
    }

    /**
     * @param navn the navn to set
     */
    public void setNavn(String navn) {
        this.navn = navn;
    }

    /**
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * @return the harSvaretRigtigt
     */
    public boolean getHarSvaretRigtigt() {
        return harSvaretRigtigt;
    }

    /**
     * @param harSvaretRigtigt the harSvaretRigtigt to set
     */
    public void setHarSvaretRigtigt(boolean harSvaretRigtigt) {
        this.harSvaretRigtigt = harSvaretRigtigt;
    }
}
