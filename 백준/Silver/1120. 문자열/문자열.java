import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        String A = stn.nextToken();
        String B = stn.nextToken();
        
        int lenA = A.length();
        int lenB = B.length();
        
        int minDiff = Integer.MAX_VALUE;
        
        for(int i=0; i<lenB-lenA+1; i++) {
            int diff = 0;
            for(int j=0; j<lenA; j++) {
                if(A.charAt(j)!=B.charAt(j+i)) {
                    diff++;
                }
            }
            
            minDiff = Math.min(minDiff, diff);
        }
        
        System.out.println(minDiff);
    }
}