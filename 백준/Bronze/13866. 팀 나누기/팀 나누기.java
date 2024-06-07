import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int minDiff = Integer.MAX_VALUE;
        
        int A = Integer.parseInt(stn.nextToken());
        int B = Integer.parseInt(stn.nextToken());
        int C = Integer.parseInt(stn.nextToken());
        int D = Integer.parseInt(stn.nextToken());
        
        minDiff = Math.min(minDiff, Math.abs((A+B)-(C+D)));
        minDiff = Math.min(minDiff, Math.abs((A+C)-(B+D)));
        minDiff = Math.min(minDiff, Math.abs((A+D)-(B+C)));
              
        System.out.println(minDiff);
    }
}