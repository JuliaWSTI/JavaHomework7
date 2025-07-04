package java;

import java.net.*;
import java.io.*;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String nazwahosta = (args.length > 0) ? args[0] : "time-a.nist.gov";                              ;

            try{
                Socket gniazdo = new Socket(nazwahosta,37);
                InputStream strumien = gniazdo.getInputStream();

                //Read 4 bytes
                int b1 = strumien.read();
                int b2 = strumien.read();
                int b3 = strumien.read();
                int b4 = strumien.read();

                // liczba sekund od 1900
                long sekundyOd1900 = ((long)b1 << 24) | ((long)b2 <<16) | ((long)b3<<8) | ((long)b4);

                //zgodność z JAVA
                long sekundyOd1970 = sekundyOd1900 - 2208988800L;

                Date time = new Date(sekundyOd1970 * 1000L);
                System.out.println("Czas z serwera: " + nazwahosta);

                gniazdo.close();

    }catch (IOException e){
            System.out.println(e);}
    }
}
