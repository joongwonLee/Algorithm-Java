import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int n, d;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(stn.nextToken());
        d = Integer.parseInt(stn.nextToken());
        
        int count = 0;
        
        for(int i=1; i<=n; i++) {
            char[] numCharArr = String.valueOf(i).toCharArray();
            
            for(int j=0; j<numCharArr.length; j++) {
                if(Integer.parseInt(String.valueOf(numCharArr[j]))==d) count++;
            }
        }
        
        System.out.println(count);
    }
}