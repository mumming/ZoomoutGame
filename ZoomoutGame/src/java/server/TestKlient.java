/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package server;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Martin
 */
public class TestKlient {
    public static void main(String args[]){
        URL url = new URL("http://[::]:9901/kontotjeneste");
        QName qname = new QName("http://kapitel_19_ws/", "KontoImplService");
        Service service = Service.create(url, qname);
        KontoI k = service.getPort(KontoI.class);
    }
}
