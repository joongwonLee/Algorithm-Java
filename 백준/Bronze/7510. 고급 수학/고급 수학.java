import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=n; i++) {
            System.out.println("Scenario #"+i+":");
            
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int aPowTwo = (int)Math.pow(Integer.parseInt(stn.nextToken()), 2);
            int bPowTwo = (int)Math.pow(Integer.parseInt(stn.nextToken()), 2);
            int cPowTwo = (int)Math.pow(Integer.parseInt(stn.nextToken()), 2);
            
            if(aPowTwo+bPowTwo==cPowTwo||aPowTwo+cPowTwo==bPowTwo||bPowTwo+cPowTwo==aPowTwo) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            System.out.println();
        }
    }
}