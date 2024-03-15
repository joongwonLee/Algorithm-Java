import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        stn = new StringTokenizer(br.readLine());
        
        int L = Integer.parseInt(stn.nextToken());
        int P = Integer.parseInt(stn.nextToken());
        
        stn = new StringTokenizer(br.readLine());
        
        for(int i=0; i<5; i++) {
            int num = Integer.parseInt(stn.nextToken());
            
            System.out.print(num-(L*P)+" ");
        }
    }
}