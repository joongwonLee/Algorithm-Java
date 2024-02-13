import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer stn;
    
    static Long A, B;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        A = Long.parseLong(stn.nextToken());
        B = Long.parseLong(stn.nextToken());
        
        System.out.println(A+B);
    }
}