import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static String str;
    static List<Character> vowels = new ArrayList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
                                                    
    static int result;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        str = String.valueOf(br.readLine());
        result = 0;
        
        for(int i=0; i<str.length(); i++) {
            if(vowels.contains(str.charAt(i))) result++;
        }
        
        System.out.println(result);
    }
}