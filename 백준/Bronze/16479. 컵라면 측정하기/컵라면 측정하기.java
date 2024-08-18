import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(stn.nextToken());
        int d2 = Integer.parseInt(stn.nextToken());
        
        System.out.println(Math.pow(K, 2) - Math.pow((Math.max(d1, d2)-Math.min(d1, d2))/2, 2));
    }
}