import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static String str;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        str = br.readLine();
        
        switch(str) {
            case "NLCS":
                System.out.println("North London Collegiate School");
                break;
            case "BHA":
                System.out.println("Branksome Hall Asia");
                break;
            case "KIS":
                System.out.println("Korea International School");
                break;
            case "SJA":
                System.out.println("St. Johnsbury Academy");
                break;
        }
    }
}