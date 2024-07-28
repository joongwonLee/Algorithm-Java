import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        int[][] originArray = new int[N][M];
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                originArray[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
        
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                System.out.print(originArray[i][j] + Integer.parseInt(stn.nextToken())+" ");
            }
            System.out.println();
        }
    }
}