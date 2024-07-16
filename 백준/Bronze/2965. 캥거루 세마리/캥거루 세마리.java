import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(stn.nextToken());
        int B = Integer.parseInt(stn.nextToken());
        int C = Integer.parseInt(stn.nextToken());
        
        System.out.println(Math.max(C-B-1, B-A-1));
    }
}