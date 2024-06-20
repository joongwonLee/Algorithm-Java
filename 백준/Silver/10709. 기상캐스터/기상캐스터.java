import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(stn.nextToken());
        int W = Integer.parseInt(stn.nextToken());
        
        char[][] map = new char[H][W];
        for(int i=0; i<H; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int[][] resultMap = new int[H][W];
        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(map[i][j]!='c') resultMap[i][j] = -1;
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                if(j==0) continue;
                if(resultMap[i][j-1]!=-1&&resultMap[i][j]!=0) resultMap[i][j] = resultMap[i][j-1]+1;
            }
        }

        for(int i=0; i<H; i++) {
            for(int j=0; j<W; j++) {
                System.out.print(resultMap[i][j]+" ");
            }
            System.out.println();
        }
    }
}