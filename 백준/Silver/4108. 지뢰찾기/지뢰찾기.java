import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int R,C;
    static char[][] map;
    
    static int[] dr = new int[]{-1, 0, 1};
    static int[] dc = new int[]{-1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            stn = new StringTokenizer(br.readLine());
            R = Integer.parseInt(stn.nextToken());
            C = Integer.parseInt(stn.nextToken());  
            
            if(R==0&&C==0) break;
            
            map = new char[R][C];
            
            for(int i=0; i<R; i++) {
                map[i] = br.readLine().toCharArray();
            }
            
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j]=='*') continue;
                    setLandminesInfo(i, j);
                }
            }
            
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
        
    }
    
    public static void setLandminesInfo(int r, int c) {
        
        int landminesCount = 0;
        
        for(int i=0; i<dr.length; i++) {
            for(int j=0; j<dc.length; j++) {
                if(i==1&&j==1) continue;
                int nowR = r+dr[i];
                int nowC = c+dc[j];
                
                if(isInRange(nowR, nowC) && map[nowR][nowC]=='*') {
                    landminesCount++;
                }
            }
        }
        map[r][c] = String.valueOf(landminesCount).charAt(0);
    }
    
    public static boolean isInRange(int r, int c) {
        return r>=0&&r<R&&c>=0&&c<C;
    }
}