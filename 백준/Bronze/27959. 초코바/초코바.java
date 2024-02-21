import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        if(100*N>=M) System.out.println("Yes");
        else System.out.println("No");
    }
}