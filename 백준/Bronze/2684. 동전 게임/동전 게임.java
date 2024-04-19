import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int P;
    
    static String[] pattern = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};
    static int[] patternMatch;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());
        
        
        for(int i=0; i<P; i++) {
            char[] text = br.readLine().toCharArray();
            patternMatch = new int[8];
            for(int j=0; j<text.length-2; j++) {
                String nowPattern = String.valueOf(text[j])+String.valueOf(text[j+1])+String.valueOf(text[j+2]);
                // System.out.println(nowPattern);
                
                for(int k=0; k<pattern.length; k++) {
                    if(pattern[k].equals(nowPattern)) {
                        patternMatch[k]++;
                    }
                }
            }
            
            for(int l=0; l<patternMatch.length; l++) {
                System.out.print(patternMatch[l]+" ");
            }
            System.out.println();
        }
    }
}