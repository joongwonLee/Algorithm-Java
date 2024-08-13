import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int W = Integer.parseInt(stn.nextToken());
        int H = Integer.parseInt(stn.nextToken());
        
        double max = Math.sqrt(Math.pow(W, 2) + Math.pow(H, 2));
        
        while(N-->0) {
            int len = Integer.parseInt(br.readLine());
            
            if((double)len <= max) System.out.println("DA");
            else System.out.println("NE");
        }
    }
}