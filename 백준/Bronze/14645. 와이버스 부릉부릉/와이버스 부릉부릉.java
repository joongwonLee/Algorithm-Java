import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int N, K;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(stn.nextToken());
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
        }
        
        System.out.println("비와이");
    }
}