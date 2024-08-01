import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    
    static int caseNum = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(stn.nextToken());
        int C = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        
        char[][] map = new char[R][C];
        
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] isVisited = new boolean[R][C];
        isVisited[R-1][0] = true;
        dfs(R-1, 0, R, C, K, map, isVisited, 1);
        
        System.out.println(caseNum);
    }
    
    static void dfs(int nowR, int nowC, int R, int C, int K, char[][] map, boolean[][] isVisited, int length) {
        
        if(nowR == 0 && nowC == C-1 && length == K) {
            caseNum++;
            return;    
        }
        
        for(int i=0; i<4; i++) {
            int nextR = nowR + dr[i];
            int nextC = nowC + dc[i];
            
            if(inRange(nextR, nextC, R, C) && !isVisited[nextR][nextC] && map[nextR][nextC]!='T') {
                isVisited[nextR][nextC] = true;
                dfs(nextR, nextC, R, C, K, map, isVisited, length+1);
                isVisited[nextR][nextC] = false;
            }
        }
    }
    
    static boolean inRange(int r, int c, int R, int C) {
        return r>=0 && r<R && c>=0 && c<C;
    }
}