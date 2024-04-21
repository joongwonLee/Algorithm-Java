import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int T;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            String letter = br.readLine();
            System.out.println(encoding(letter));
        }
    }
    
    public static String encoding(String str) {
        int length = str.length();
        int sqrt = (int)Math.sqrt(length);
        char[][] letterMap = new char[sqrt][sqrt];
        
        for(int i=0; i<sqrt; i++) {
            letterMap[i] = str.substring(i*sqrt, (i+1)*sqrt).toCharArray();
        }
        
        StringBuffer encodedLetter = new StringBuffer();
        
        for(int i=sqrt-1; i>=0; i--) {
            for(int j=0; j<sqrt; j++) {
                encodedLetter.append(String.valueOf(letterMap[j][i]));
            }
        }
        
        return String.valueOf(encodedLetter);
    }
}