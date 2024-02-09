import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static int A, B;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        
        System.out.println(A+B);
    }
}