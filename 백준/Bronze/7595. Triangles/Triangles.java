import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            int num = Integer.parseInt(br.readLine());
            
            if(num==0) break;
            
            for(int i=1; i<=num; i++) {
                for(int j=0; j<i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}