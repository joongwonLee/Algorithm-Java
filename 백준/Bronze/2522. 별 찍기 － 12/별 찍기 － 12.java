import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=2*N-1; i++) {
            
            int abs = Math.abs(N-i);
            
            for(int j=1; j<=N; j++) {
                if(j>abs) System.out.print("*");
                else System.out.print(" ");
            }
            
            System.out.println();
        }
    }
}