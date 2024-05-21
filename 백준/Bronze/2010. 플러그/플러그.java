import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        
        for(int i=0; i<N; i++) {
            int multiTap = Integer.parseInt(br.readLine());
            sum += multiTap;
        }

        sum-=(N-1);
        
        System.out.println(sum);
    }
}