import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N-->0) {
            char[] inputArray = br.readLine().toCharArray();
            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i<inputArray.length; i++) {
                if(i==0) sb.append(String.valueOf(inputArray[i]).toUpperCase());
                else sb.append(String.valueOf(inputArray[i]));
            }
            
            System.out.println(sb);
        }
    }
}