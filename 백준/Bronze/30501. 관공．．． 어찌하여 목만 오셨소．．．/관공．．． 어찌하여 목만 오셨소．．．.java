import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        while(N-->0) {
            String enemy = br.readLine();
            if(enemy.contains("s")||enemy.contains("S")) System.out.println(enemy);
        }
    }
}