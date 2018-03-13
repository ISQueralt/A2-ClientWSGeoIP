package a2.clientwsgeoip;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import java.util.Scanner;

/**
 *
 * @author Queralt
 */

public class A2ClientWSGeoIP {
    public static void main(String[] args) throws MalformedURLException, IOException, Exception {
        
        System.out.println("1 - Get Geo IP");
        System.out.println("2 - Get Geo IP Context");
        System.out.print("Enter a number: ");
        
        switch(new Scanner(System.in).nextInt()) {
            case 1:
                System.out.print("Enter an IP: ");
                String ip = new Scanner(System.in).nextLine();
                
                URL url2 = new URL("http://www.webservicex.net/geoipservice.asmx/GetGeoIP");
                Scanner scan2 = new Scanner(url2.openStream());
                String source2 = new String();
                while (scan2.hasNext()) {
                    source2 += scan2.nextLine();
                }
                    
                Serializer serializer1 = new Persister();
                IP IP = new IP();
                IP.setIP(ip);
                serializer1.read(IP,source2);
               
                System.out.println("Return code = " + IP.getIP());
                System.out.println("IP = " + IP.getIP());
                System.out.println("Return code details = " + IP.getReturnCodeDetails());
                System.out.println("Country name = " + IP.getCountryName());
                System.out.println("Country code = " + IP.getCountryCode());
                break;
            
            case 2:
               
                URL url1 = new URL("http://www.webservicex.net/geoipservice.asmx/GetGeoIPContext");
                Scanner scan1 = new Scanner(url1.openStream());
                String source1 = new String();
                while (scan1.hasNext()) {
                    source1 += scan1.nextLine();
                }
       
                Serializer serializer2 = new Persister();
                IP IP2 = new IP();
                serializer2.read(IP2,source1);
                
                System.out.println("Return code = " + IP2.getReturnCode());
                System.out.println("IP = " + IP2.getIP());
                System.out.println("Return code details = " + IP2.getReturnCodeDetails());
                System.out.println("Country name = " + IP2.getCountryName());
                System.out.println("Country code = " + IP2.getCountryCode());
                break;
                
           default:
               
                System.out.println("The number must be between 1-2.");
                break;
       }
    }
}