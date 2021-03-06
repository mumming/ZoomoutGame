/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package server;

import java.util.ArrayList;

/**
 *
 * @author Martin
 */
public class SpilLogikImpl implements ISpilLogik {
    ArrayList<Spiller> brugerListe = new ArrayList<>();
    String svar = "bummelum";
    int nummerRigtigt;
    int antalSpillere;
    
    public SpilLogikImpl(){
        this.nummerRigtigt = 1;
        this.antalSpillere = 0;
        this.hentSpildata();
    }
    
    @Override
    public boolean modtagGaet(String spillerNavn, String gaet) {
        if(gaet.equals(svar)){
            Spiller sp = new Spiller("NNNEEEIII");
            for(Spiller s:brugerListe){
                if(s.getNavn().equals(spillerNavn)){
                    if(s.getHarSvaretRigtigt())
                        return false;
                    sp = s;
                    break;
                }
            }
            if(sp.getNavn().equals("NNNEEEIII"))
                return false;
            switch(this.nummerRigtigt){
                case 1:
                    sp.setPoints(sp.getPoints()+10);
                    sp.setHarSvaretRigtigt(true);
                    this.nummerRigtigt++;
                    System.out.println("Jaaaaaaaaaa");
                    if(this.antalSpillere<this.nummerRigtigt)
                        nyRunde();
                    return true;
                case 2:
                    sp.setPoints(sp.getPoints()+5);
                    sp.setHarSvaretRigtigt(true);
                    this.nummerRigtigt++;
                    if(this.antalSpillere<this.nummerRigtigt)
                        nyRunde();
                    return true;
                default:
                    sp.setPoints(sp.getPoints()+2);
                    sp.setHarSvaretRigtigt(true);
                    nyRunde();
                    return true;
            }
        }
        return false;
    }
    
    /**
     *  Metode til at registrere sig i chatten
     * @param navn
     * @return true if name isnt taken, false if name is taken
     */
    @Override
    public boolean registrerBruger(String navn) {
        for(int i = 0; i<brugerListe.size(); i++){
            if(navn.equals(brugerListe.get(i).getNavn())) {
                return false;
            }
            antalSpillere++;
        }
        return true;
    }
    
    @Override
    public void hentSpildata() {
        //TODO lav denne
        
    }
    
    public void nyRunde(){
        this.nummerRigtigt = 1;
        for(Spiller s:this.brugerListe)
            s.setHarSvaretRigtigt(false);
    }
    
    /**
     * Metode der skal kaldes når et spil er færdigt.
     * @return String til visning med meddelelse om vinderne
     */
    public String afslutSpil(){
        int maxPoints = 0;
        int antalVindere = 0;
        Spiller[] vindere = new Spiller[20];
        String vinderString;
        for(Spiller spiller:brugerListe){
            if(spiller.getPoints()>maxPoints)
                maxPoints = spiller.getPoints();
        }
        for(Spiller spiller:brugerListe){
            if(spiller.getPoints() == maxPoints){
                vindere[antalVindere] = spiller;
                antalVindere++;
                
            }
        }
        
        switch (antalVindere) {
            case 0:
                vinderString = "Der var ingen vinder. I er uduelige!";
                break;
            case 1:
                vinderString = "Vinderen er: " + vindere[0].getNavn() + " med " + vindere[0].getPoints() + " points. Tillykke!";
                break;
            default:
                vinderString = "Vindererne er: " + vindere[0].getNavn();
                break;
        }
        for(int i = 1; i<antalVindere;i++){
            vinderString = vinderString.concat(", " + vindere[i]);
        }
        return vinderString + " med" + vindere[0].getPoints() + " points. Tillykke!";
    }
}
