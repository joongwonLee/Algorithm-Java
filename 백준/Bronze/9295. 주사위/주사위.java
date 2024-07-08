import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=T; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
            
            System.out.println("Case "+i+": "+(A+B));
        }
    }
}