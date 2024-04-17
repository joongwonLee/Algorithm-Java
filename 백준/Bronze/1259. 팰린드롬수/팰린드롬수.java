import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            if(input.equals("0")) break;
            
            if(isPalindrom(input)) System.out.println("yes");
            else System.out.println("no");
        }
    }
    
    public static boolean isPalindrom(String str) {
        int length = str.length();
        
        for(int i=0; i<length/2; i++) {
            char first = str.charAt(i);
            char second = str.charAt(length-i-1);
            
            if(first!=second) return false;
        }
        
        return true;
    }
}