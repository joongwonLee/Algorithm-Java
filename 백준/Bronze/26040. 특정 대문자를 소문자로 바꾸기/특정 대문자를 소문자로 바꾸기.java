import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] stringA = br.readLine().toCharArray();
        String[] listB = br.readLine().split(" ");
        
        StringBuffer sb = new StringBuffer();
        
        for(int i=0; i<stringA.length; i++) {
            boolean isMatch = false;
            for(int j=0; j<listB.length; j++) {
                if(String.valueOf(stringA[i]).equals(listB[j])) {
                    isMatch = true;
                    break;
                }
            }
            if(isMatch) sb.append(String.valueOf(stringA[i]).toLowerCase());
            else sb.append(String.valueOf(stringA[i]));
        }
        
        System.out.println(sb);
    }
}