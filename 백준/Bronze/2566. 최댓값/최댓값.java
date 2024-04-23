import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int maxValue, maxColumn, maxRow;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        maxValue = Integer.MIN_VALUE;
        
        for(int i=1; i<=9; i++) {
            stn = new StringTokenizer(br.readLine());
            
            for(int j=1; j<=9; j++) {
                int input = Integer.parseInt(stn.nextToken());
                if(input>maxValue) {
                    maxColumn = i;
                    maxRow = j;
                    maxValue = input;
                }
            }
        }
        
        System.out.println(maxValue);
        System.out.println(maxColumn+" "+maxRow);
    }
}