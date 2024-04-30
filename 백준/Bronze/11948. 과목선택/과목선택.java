import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int minOne, sumOne, maxTwo;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        minOne = Integer.MAX_VALUE;
        sumOne = 0;
        maxTwo = Integer.MIN_VALUE;
        
        for(int i=0; i<4; i++) {
            int point = Integer.parseInt(br.readLine());
            minOne = Math.min(minOne, point);
            sumOne += point;
        }
        
        for(int i=0; i<2; i++) {
            int point = Integer.parseInt(br.readLine());
            maxTwo = Math.max(maxTwo, point);
        }
        
        sumOne -= minOne;
        
        System.out.println(sumOne+maxTwo);
    }
}