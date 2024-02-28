import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int date;
    static int result;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        date = Integer.parseInt(br.readLine());
        
        stn = new StringTokenizer(br.readLine());
        result = 0;
        
        for(int i=0; i<5; i++) {
            int carNum = Integer.parseInt(stn.nextToken());
            if(carNum==date) result++;
        }
        
        System.out.println(result);
    }
}