import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static String str1, str2;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        str1 = br.readLine();
        str2 = br.readLine();
        
        if(str1.length() < str2.length()) System.out.println("no");
        else System.out.println("go");
    }
}