import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alphabetNum = new int[26];
        
        for(int i=0; i<N; i++) {
            char ch = br.readLine().charAt(0);
            alphabetNum[(int)ch-97]++;
        }
        
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<26; i++) {
            if(alphabetNum[i]>=5) sb.append(String.valueOf((char)(i+97)));
        }
        
        if(sb.length()==0) System.out.println("PREDAJA");
        else System.out.println(sb);
    }
}