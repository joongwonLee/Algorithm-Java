import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int H = Integer.parseInt(br.readLine());
        int W = Integer.parseInt(br.readLine());
        
        System.out.println(Math.min(H, W) * 50);
    }
}