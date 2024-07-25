import java.util.*;
import java.io.*;


public class Main {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int yook = Integer.parseInt(stn.nextToken());
        int je = Integer.parseInt(stn.nextToken());
        
        double result = 1/(1+Math.pow(10, (double)(je-yook)/400));

        System.out.println(result);
    }
}