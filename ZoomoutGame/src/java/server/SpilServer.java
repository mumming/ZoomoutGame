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
import javax.xml.ws.Endpoint;

class SpilServer {
    public static void main(String[] args) {
        System.out.println("publicerer spil");
        ISpilLogik sl = new SpilLogikImpl();
        // Ipv6-addressen [::] svarer til Ipv4-adressen 0.0.0.0, der matcher alle maskinens netkort og
        Endpoint.publish("http://[::]:9901/SpilLogik", sl);
        System.out.println("Spil publiceret.");
    }
}
