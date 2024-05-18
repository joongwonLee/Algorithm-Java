import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        int totalSum = 0;
        for(int i=65; i<=90; i++) {
            totalSum += i;
        }
        
        while(T-->0) {
            char[] inputCharArray = br.readLine().toCharArray();
            boolean[] isChecked = new boolean[26];
            
            int asciiSum = 0;
            for(int i=0; i<inputCharArray.length; i++) {
                char ch = inputCharArray[i];
                if(!isChecked[ch-65]) {
                    isChecked[ch-65] = true;
                    asciiSum += inputCharArray[i];
                }
            }
            
            System.out.println(totalSum-asciiSum);
        }
    }
}