package inetaddressex;

import java.net.InetAddress;
import java.net.UnknownHostException;

        
public class InetAddressex {
    public static void main(String[] args) {
        try{
            InetAddress host = InetAddress.getByName("www.gva.es");
            System.out.println("Host: "+host);
            System.out.println("IP: "+host.getHostAddress());
            System.out.println("Nombre: "+host.getHostName());
            System.out.println("Localhost: "+InetAddress.getLocalHost());
        }catch(UnknownHostException ex){
            System.out.println("Host desconocido");
        }
    }
}
