import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            
            stn = new StringTokenizer(br.readLine());
            
            int firstNum = Integer.parseInt(stn.nextToken());
            int secondNum = Integer.parseInt(stn.nextToken());
            
            if(firstNum==0&&secondNum==0) break;
            
            if(firstNum>secondNum) System.out.println("Yes");
            else System.out.println("No");
        }
    } 
}