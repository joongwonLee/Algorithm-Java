import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(stn.nextToken());
            int E = Integer.parseInt(stn.nextToken());
            
            System.out.println(2-V+E);
        }
    }
}