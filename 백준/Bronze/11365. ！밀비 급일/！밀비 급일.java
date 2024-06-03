import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine();
            if(str.equals("END")) break;
            
            System.out.println(reverseString(str));
        }
    }
    
    public static String reverseString(String str) {
        String reversed="";
        
        for(int i=str.length()-1; i>=0; i--) {
            reversed+=String.valueOf(str.charAt(i));
        }
        
        return reversed;
    }
}