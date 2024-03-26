import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        System.out.println(Fibonacci(N));
    }
    
    public static long Fibonacci(int n) {
        if(n==0) return 1;
        else return n*Fibonacci(n-1);
    }
}