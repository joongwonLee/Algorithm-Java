import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        while(n-->0) {
            int k = Integer.parseInt(br.readLine());
            while(k-->0) {
                System.out.print("=");
            }
            System.out.println();
        }
    }
}