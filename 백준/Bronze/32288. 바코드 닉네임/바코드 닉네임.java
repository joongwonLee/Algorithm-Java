import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        char[] inputArray = br.readLine().toCharArray();
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<n; i++) {
            char ch = inputArray[i];
            if(Character.isLowerCase(ch)) sb.append(String.valueOf(Character.toUpperCase(ch)));
            else sb.append(String.valueOf(Character.toLowerCase(ch)));
 
        }
        
        System.out.println(sb);
    }
}