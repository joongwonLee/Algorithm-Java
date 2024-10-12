import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            if(input.equals("*")) break;
            
            boolean[] alphabet = new boolean[26];
            boolean isPangram = true;
            
             for(int i=0; i<input.length(); i++) {
                 char ch = input.charAt(i);
                 if(ch==' ') continue;
                 
                 alphabet[(int)ch - 97] = true;
             }
            
            for(int i=0; i<alphabet.length; i++) {
                if(!alphabet[i]) isPangram = false;
            }
            
            if(isPangram) System.out.println('Y');
            else System.out.println('N');
        }
    }
}