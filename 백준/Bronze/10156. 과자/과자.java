import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(stn.nextToken());
        int N = Integer.parseInt(stn.nextToken());
        
        int M = Integer.parseInt(stn.nextToken());
        
        if(K*N > M) System.out.println(K*N-M);
        else System.out.println(0);
    }
}