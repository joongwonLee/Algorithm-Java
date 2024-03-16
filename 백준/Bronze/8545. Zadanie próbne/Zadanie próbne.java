import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static String str;
    static String result;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        str = String.valueOf(br.readLine());
        result = "";
        
        for(int i=str.length()-1; i>=0; i--) {
            result += str.charAt(i);
        }
        
        System.out.println(result);
    }
}