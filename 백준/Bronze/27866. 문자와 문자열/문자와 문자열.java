import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static String S;
    static int i;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        S = String.valueOf(br.readLine());
        i = Integer.parseInt(br.readLine());
        
        System.out.println(S.toCharArray()[i-1]);
    }
}