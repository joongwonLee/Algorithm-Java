import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            
            System.out.println(Integer.parseInt(stn.nextToken()) + Integer.parseInt(stn.nextToken()));
        }
    }
}