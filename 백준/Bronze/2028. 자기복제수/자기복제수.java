import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            int len = String.valueOf(N).length();
            String nPow = String.valueOf((int)Math.pow(N, 2));
            
            if(Integer.parseInt(nPow.substring(nPow.length()-len, nPow.length()))==N) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}