import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int iter = N/4;
        
        for(int i=0; i<iter; i++) {
            System.out.print("long ");
        }
        System.out.print("int");
    }
}