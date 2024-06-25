import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(stn.nextToken());
        int I = Integer.parseInt(stn.nextToken());
        
        System.out.println(A*(I-1)+1);
    }
}