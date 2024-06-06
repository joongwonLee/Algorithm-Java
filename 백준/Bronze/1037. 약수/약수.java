import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfDivisor = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<numOfDivisor; i++) {
            int input = Integer.parseInt(stn.nextToken());
            max = Math.max(max, input);
            min = Math.min(min, input);
        }
        
        System.out.println(max*min);
    }
}