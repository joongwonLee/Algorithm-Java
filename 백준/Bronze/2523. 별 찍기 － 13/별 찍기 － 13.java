import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=2*N-1; i++) {
            
            int iterNum = (i<N) ? i : 2*N-i;
            
            for(int j=0; j<iterNum; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }
}