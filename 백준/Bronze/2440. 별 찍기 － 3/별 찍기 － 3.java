import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int n;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        for(int i=n; i>0; i--) {
            for(int j=i; j>0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}