import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] kiwiGround = new String[10][10];
        
        for(int i=0; i<10; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                kiwiGround[i][j] = stn.nextToken();
            }
        }
        
        boolean canDureum = false;
        
        for(int i=0; i<10; i++) {
            String first = kiwiGround[i][i];
            boolean hoxyDureum = true;
            for(int j=0; j<10; j++) {
                if(i==j) continue;
                String next = kiwiGround[i][j];
                if(!first.equals(next)) {
                    hoxyDureum = false;
                    break;
                }
            }
            
            if(hoxyDureum) {
                canDureum = true;
                break;
            }
            
            hoxyDureum = true;
            for(int j=0; j<10; j++) {
                if(i==j) continue;
                String next = kiwiGround[j][i];
                if(!first.equals(next)) {
                    hoxyDureum = false;
                    break;
                }
            }

            if(hoxyDureum) {
                canDureum = true;
                break;
            }
        }
        
        if(canDureum) System.out.println("1");
        else System.out.println("0");
    }
}