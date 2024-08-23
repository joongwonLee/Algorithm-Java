import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            char[] inputArray = br.readLine().toCharArray();
            
            StringBuffer sb = new StringBuffer();
            
            for(int i=0; i<inputArray.length; i++) {
                if(i==0) {
                    sb.append(String.valueOf(inputArray[i]));
                } else {
                    if(inputArray[i]!=inputArray[i-1]) sb.append(String.valueOf(inputArray[i]));
                }
            }
            System.out.println(sb);
        }
    }
}