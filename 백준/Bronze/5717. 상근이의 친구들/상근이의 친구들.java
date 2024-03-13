import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            stn = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
            
            if(A==0&&B==0) break;
            
            System.out.println(A+B);
        }
    }
}