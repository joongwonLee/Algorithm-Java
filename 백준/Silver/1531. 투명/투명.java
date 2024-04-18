import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int N, M, result;
    static int[][] pictureMap;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        
        pictureMap = new int[101][101];
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(stn.nextToken());
            int leftY = Integer.parseInt(stn.nextToken());
            int rightX = Integer.parseInt(stn.nextToken());
            int rightY = Integer.parseInt(stn.nextToken());
            
            for(int j=leftX; j<=rightX; j++) {
                for(int k=leftY; k<=rightY; k++) {
                    pictureMap[j][k]+=1;
                }
            }
        }
        
        result = 0;
        
        for(int i=1; i<=100; i++) {
            for(int j=1; j<=100; j++) {
                if(pictureMap[i][j]>M) result++; 
            }
        }
        
        System.out.println(result);
    }
}