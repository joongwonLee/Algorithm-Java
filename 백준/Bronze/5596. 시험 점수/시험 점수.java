import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        int minguk = 0;
        int manse = 0;
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            minguk += Integer.parseInt(stn.nextToken());
        }
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            manse += Integer.parseInt(stn.nextToken());
        }
        
        int result = Math.max(minguk, manse);
        System.out.println(result);
    }
}