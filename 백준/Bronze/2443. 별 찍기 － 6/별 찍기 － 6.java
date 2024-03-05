import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int n;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++) {
            
            for(int j=0; j<i; j++) {
                System.out.print(" ");
            }
            
            for(int j=0; j<2*n-(1+2*i); j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
    }
}