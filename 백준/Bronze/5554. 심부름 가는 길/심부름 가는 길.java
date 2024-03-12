import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static int sum;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<4; i++) {
            int time = Integer.parseInt(br.readLine());
            sum += time;
        }
        
        System.out.println(sum/60);
        System.out.println(sum%60);
    }
}