import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        char[] rbArray = br.readLine().toCharArray();
        int rCount = 0, bCount = 0;
        if(rbArray[0]=='B') bCount++;
        else rCount++;
        
        for(int i=0; i<N-1; i++) {
            char now = rbArray[i];
            char after = rbArray[i+1];
            
            if(now!=after) {
                if(after=='B') bCount++;
                else rCount++;
            }
        }
        
        int result = 1+Math.min(rCount, bCount);
        System.out.println(result);
    }
}