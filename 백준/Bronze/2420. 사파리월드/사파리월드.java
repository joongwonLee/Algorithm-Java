import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        long A = Long.parseLong(stn.nextToken());
        long B = Long.parseLong(stn.nextToken());
        
        System.out.println(Math.abs(A-B));
    }
}