import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int W = Integer.parseInt(stn.nextToken());
        int H = Integer.parseInt(stn.nextToken());
        
        System.out.printf("%.1f", (double)(W*H)/2);
    }
}