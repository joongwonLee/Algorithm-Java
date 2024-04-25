import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn; 
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            stn = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());
            
            if(a==0&&b==0) break;
            
            if(b%a==0) System.out.println("factor");
            else if(a%b==0) System.out.println("multiple");
            else System.out.println("neither");
        }
    }
}