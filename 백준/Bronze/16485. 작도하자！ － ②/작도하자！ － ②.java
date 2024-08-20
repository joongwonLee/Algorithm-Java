import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(stn.nextToken());
        int b = Integer.parseInt(stn.nextToken());
        
        System.out.println((double)a/(double)b);
    }
}