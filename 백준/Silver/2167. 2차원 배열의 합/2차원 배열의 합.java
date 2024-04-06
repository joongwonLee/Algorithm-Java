import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int N, M, K;
    static int[][] intArray;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        
        intArray = new int[N+1][M+1];
        
        for(int i=1; i<=N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                intArray[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
        
        K = Integer.parseInt(br.readLine());
        
        for(int i=0; i<K; i++) {
            stn = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(stn.nextToken());
            int y1 = Integer.parseInt(stn.nextToken());
            int x2 = Integer.parseInt(stn.nextToken());
            int y2 = Integer.parseInt(stn.nextToken());
            
            System.out.println(sumOfArray(x1, y1, x2, y2));
        }
        
    }
    
    public static int sumOfArray(int x1, int y1, int x2, int y2) {
        
        int sum = 0;
        
        for(int i=x1; i<=x2; i++) {
            for(int j=y1; j<=y2; j++) {
                sum += intArray[i][j];
            }
        }
        
        return sum;
    }
}