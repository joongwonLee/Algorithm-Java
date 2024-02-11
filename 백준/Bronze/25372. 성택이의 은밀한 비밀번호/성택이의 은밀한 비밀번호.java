import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static int T;
    static String str;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            str = br.readLine();
            
            if(str.length()>=6&&str.length()<=9) System.out.println("yes");
            else System.out.println("no");
        }
    }
}