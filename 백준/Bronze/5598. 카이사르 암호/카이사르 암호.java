import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArray = br.readLine().toCharArray();
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<inputArray.length; i++) {
            char inputCh = inputArray[i];
            if((int)inputCh <= 67) sb.append(String.valueOf((char)((int)inputCh+23)));
            else sb.append(String.valueOf((char)((int)inputCh-3)));
        }
        
        System.out.println(sb);
    }
}