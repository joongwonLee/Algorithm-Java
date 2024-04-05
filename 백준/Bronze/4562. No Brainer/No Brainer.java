import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int N, x, y;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            
            x = Integer.parseInt(stn.nextToken());
            y = Integer.parseInt(stn.nextToken());
            
            if(x<y) System.out.println("NO BRAINS");
            else System.out.println("MMM BRAINS");
        }
    }
}