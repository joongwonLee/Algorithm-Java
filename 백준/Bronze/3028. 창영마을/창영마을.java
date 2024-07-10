import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputArray = br.readLine().toCharArray();
        
        int now = 1;
        
        for(int i=0; i<inputArray.length; i++) {
            now = shuffleCup(now, inputArray[i]);
        }
        
        System.out.println(now);
        
    }
    
    static int shuffleCup(int now, char pattern) {
        
        int pos = now;
        
        if(pattern=='A') {
            if(pos==1) pos = 2;
            else if(pos==2) pos = 1;
        } else if(pattern=='B') {
            if(pos==2) pos = 3;
            else if(pos==3) pos = 2;
        } else {
            if(pos==1) pos = 3;
            else if(pos==3) pos = 1;
        }
        
        return pos;
    }
}