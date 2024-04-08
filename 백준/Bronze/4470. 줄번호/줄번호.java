import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=N; i++) {
            String input = String.valueOf(br.readLine());
            
            System.out.println(i+". "+input);
        }
    }
}