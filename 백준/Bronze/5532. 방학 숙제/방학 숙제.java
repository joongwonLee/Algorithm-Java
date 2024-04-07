import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int L, A, B, C, D;
    static int result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        L = Integer.parseInt(br.readLine());
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        D = Integer.parseInt(br.readLine());
        
        int dayOfKorean = (A%C==0) ? A/C : A/C+1;
        int dayOfMath = (B%D==0) ? B/D : B/D+1;
        result = L-Math.max(dayOfKorean, dayOfMath);
        
        System.out.println(result);
    }
}