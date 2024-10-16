import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    
    static int minMove = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[5][5];
        for(int i=0; i<5; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(stn.nextToken());
        int startC = Integer.parseInt(stn.nextToken());

        map[startR][startC] = -1;
        if(map[startR][startC]==1) backtracking(0, 1, startR, startC, map);
        else backtracking(0, 0, startR, startC, map);

        if(minMove == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(minMove);
    } 
    
    static void backtracking(int apple, int path, int r, int c, int[][] map) {
        
        if(apple==3) {
            minMove = Math.min(minMove, path);
            return;
        }
        
        for(int i=0; i<4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            
            if(inRange(nextR, nextC) && map[nextR][nextC] != -1) {
                int next = map[nextR][nextC]; 
                map[nextR][nextC] = -1; // 지난 길은 -1로 
                if(next==1) backtracking(apple+1, path+1, nextR, nextC, map);
                else backtracking(apple, path+1, nextR, nextC, map);
                map[nextR][nextC] = next; // backtracking을 dfs로 하기 때문에 다시 되돌려주어야 함
            }
        }
    }
    
    static boolean inRange(int r, int c) {
        return r>=0&&r<5&&c>=0&&c<5;
    }
}