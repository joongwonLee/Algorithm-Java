import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] points = new int[N];
        for(int i=0; i<N; i++) {
            points[i] = Integer.parseInt(br.readLine());
        }
        
        int result = 0;
        for(int i=N-1; i>0; i--) {
            int now = points[i];
            int before = points[i-1];
            
            if(now>before) continue;
            
            points[i-1] = now-1;
            int diff = before-(points[i-1]);
            result+=diff;
        }
        
        System.out.println(result);
    }
}