import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static long N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Long.parseLong(br.readLine());
        
        while(true) {
            if(!isPrime(N)) {
                System.out.print(N);
                break;
            }
            
            N++;
        }
    }
    
    private static boolean isPrime(long num) {
        
        if(num==1) return false;
        
        for(int i=2; i<=Math.sqrt(num); i++) {
            
            if(num%i==0) return false;
            
//            for(int j=i*2; j<num; j+=i) {
//                if(num%j==0) return false;
//            }
        }
        
        return true;
    }
}