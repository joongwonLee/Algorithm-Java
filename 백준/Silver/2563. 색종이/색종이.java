import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    static int N, result;
    static boolean[][] boolMap;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        boolMap = new boolean[100][100];
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            
            int left = Integer.parseInt(stn.nextToken());
            int bottom = Integer.parseInt(stn.nextToken());
            
            for(int j=left; j<left+10; j++) {
                for(int k=bottom; k<bottom+10; k++) {
                    if(!boolMap[j][k]) boolMap[j][k] = true;
                }
            }
        }
        
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(boolMap[i][j]) result++;
            }
        }
        
        System.out.println(result);
    }
}