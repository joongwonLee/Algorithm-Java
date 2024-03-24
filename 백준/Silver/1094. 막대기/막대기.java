import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int X;
    
    static int binaryCount;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        X = Integer.parseInt(br.readLine());
        binaryCount = 0;
        
        while(X!=0) {
            
            int n = 0;
            while(Math.pow(2,n+1)<=X) {
                n++;
            }
            
            X-=Math.pow(2,n);
            binaryCount++;
        }
        
        System.out.println(binaryCount);
    }
}