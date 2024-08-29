import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int W = Integer.parseInt(stn.nextToken());
        int H = Integer.parseInt(stn.nextToken());
        int L = Integer.parseInt(stn.nextToken());
        
        int result = Math.min(N, (W/L)*(H/L));
        System.out.println(result);
    }
}