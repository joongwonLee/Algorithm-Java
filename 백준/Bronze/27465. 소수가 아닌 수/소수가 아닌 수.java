import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        while(true) {
            if(!isPrime(N)) {
                System.out.print(N);
                break;
            }
            
            N++;
        }
    }
    
    private static boolean isPrime(int num) {
        
        if(num==1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            
            for(int j=i*2; j<=num; j+=i) {
                if(num%j==0) return false;
            }
        }
        
        return true;
    }
}