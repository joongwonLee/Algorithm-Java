import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        int K = 1;
        
        while(N!=0) {
            if(N<K) {
                K = 1;
                continue;
            }
            
            N-=K;
            K++;
            result++;
        }
        
        System.out.println(result);
    }
}