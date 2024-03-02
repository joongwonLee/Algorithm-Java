import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int T;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            stn = new StringTokenizer(br.readLine());
            
            int sum = 0;
            int min = Integer.MAX_VALUE;
            
            for(int j=0; j<7; j++) {
                int num = Integer.parseInt(stn.nextToken());
            
                if(num%2==0) {
                    sum+=num;
                    min=Math.min(min, num);
                }
            }
            
            System.out.println(sum+" "+min);
            
        }
    }
}