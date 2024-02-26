import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static String str;
    static List<Character> vowels = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
    
    static int numOfVowel;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            str = String.valueOf(br.readLine());
          
            if(str.equals("#")) break;
            
            numOfVowel = 0;
            
            for(int i=0; i<str.length(); i++) {
                if(vowels.contains(str.charAt(i))) numOfVowel++;
            }
            
            System.out.println(numOfVowel);
            
        }
    }
}