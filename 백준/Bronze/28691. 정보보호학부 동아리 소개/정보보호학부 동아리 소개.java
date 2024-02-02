import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static char c;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        c = br.readLine().charAt(0);
        
        if(c=='M') System.out.println("MatKor");
        else if(c=='W') System.out.println("WiCys");
        else if(c=='C') System.out.println("CyKor");
        else if(c=='A') System.out.println("AlKor");
        else System.out.println("$clear");
    }
}