import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabetNum = new int[26];
        
        while(true) {
            String input = br.readLine();
            if(input==null) break;
            
            for(int i=0; i<input.length(); i++) {
                char ch = input.charAt(i);
                if(ch==' ') continue;
                alphabetNum[(int)ch-97]++;
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++) {
            max = Math.max(max, alphabetNum[i]);
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<26; i++) {
            if(alphabetNum[i]==max) sb.append(String.valueOf((char)(i+97)));
        }

        System.out.println(sb);
    }
}