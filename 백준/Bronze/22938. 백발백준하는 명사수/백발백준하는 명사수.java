import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int x1 = Integer.parseInt(stn.nextToken());
        int y1 = Integer.parseInt(stn.nextToken());
        int R1 = Integer.parseInt(stn.nextToken());
        
        stn = new StringTokenizer(br.readLine());
        
        int x2 = Integer.parseInt(stn.nextToken());
        int y2 = Integer.parseInt(stn.nextToken());
        int R2 = Integer.parseInt(stn.nextToken());
        
        double dist = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
        
        if(R1+R2>dist) System.out.println("YES");
        else System.out.println("NO");
    }
}