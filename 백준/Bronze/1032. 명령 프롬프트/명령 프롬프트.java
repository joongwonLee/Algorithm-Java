import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N, length;
    static String[] fileNameArray;
    static char[] patternArray;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        fileNameArray = new String[N];
        
        for(int i=0; i<N; i++) {
            fileNameArray[i] = br.readLine();
        }
        
        length = fileNameArray[0].length();
        patternArray = new char[length];
        patternArray = fileNameArray[0].toCharArray();
        
        for(int i=1; i<N; i++) {
            
            String str = fileNameArray[i];
            
            for(int j=0; j<str.length(); j++) {
                if(patternArray[j]!=str.charAt(j)) {
                    patternArray[j] = '?';
                }
            }
        }
        
        for(int i=0; i<patternArray.length; i++) {
            System.out.print(patternArray[i]);
        }
    }
}