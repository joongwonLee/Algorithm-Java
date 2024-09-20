import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int fbiCount = 0;
        
        for(int i=1; i<=5; i++) {
            String agent = br.readLine();
            
            for(int j=0; j<agent.length()-2; j++) {
                if(agent.charAt(j)=='F' && agent.substring(j, j+3).equals("FBI")) {
                    System.out.print(i+" ");
                    fbiCount++;
                    break;
                }
            }
        }
        
        if(fbiCount==0) {
            System.out.println("HE GOT AWAY!");
        }
    }
}