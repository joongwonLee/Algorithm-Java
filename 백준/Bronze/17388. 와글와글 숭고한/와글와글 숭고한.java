import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        int H = Integer.parseInt(stn.nextToken());
        
        if(S+K+H>=100) System.out.println("OK");
        else {
            int min = Math.min(S, Math.min(K, H));
            if(S==min) {
                System.out.println("Soongsil");
            } else if(K==min) {
                System.out.println("Korea");
            } else {
                System.out.println("Hanyang");
            }
        }
    }
}