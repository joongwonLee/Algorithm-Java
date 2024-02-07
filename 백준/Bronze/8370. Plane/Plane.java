import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        int n1 = Integer.parseInt(stn.nextToken());
        int k1 = Integer.parseInt(stn.nextToken());
        int n2 = Integer.parseInt(stn.nextToken());
        int k2 = Integer.parseInt(stn.nextToken());
        
        System.out.println(n1*k1 + n2*k2);
    }
}