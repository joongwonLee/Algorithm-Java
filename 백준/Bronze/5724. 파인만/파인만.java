import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            
            int squareNum = 0;
            while(N>0) {
                squareNum+=Math.pow(N--,2);
            }
            
            System.out.println(squareNum);
        }
    }
}