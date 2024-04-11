import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        System.out.print(num/11*10);
    }
}