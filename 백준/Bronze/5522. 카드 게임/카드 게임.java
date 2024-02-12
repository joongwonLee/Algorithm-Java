import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        
        for(int i=0; i<5; i++) sum += Integer.parseInt(br.readLine());
        
        System.out.println(sum);
    }
}