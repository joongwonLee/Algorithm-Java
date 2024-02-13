import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        
        System.out.println(a*b);
    }
}