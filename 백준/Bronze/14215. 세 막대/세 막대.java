import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(stn.nextToken());
        int b = Integer.parseInt(stn.nextToken());
        int c = Integer.parseInt(stn.nextToken());
        
        int max = Math.max(Math.max(a, b), c);
        int min = Math.min(Math.min(a, b), c);

        int sumMinusMax = a+b+c-max;
        
        while(max>=sumMinusMax) {
            max--;
        }
        
        System.out.println(sumMinusMax+max);
    }
}