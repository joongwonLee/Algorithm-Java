import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            
            int sum = 0;
            for(int i=1; i<=N; i++) {
                sum+=i;
            }
            System.out.println(sum);
        }
    }
}