import java.util.*;
import java.io.*;

public class Main {
    
    static int[] rDir = new int[]{1, 0, -1, 0};
    static int[] cDir = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(stn.nextToken());
        int m = Integer.parseInt(stn.nextToken());
        
        int startR = 0, startC = 0;
        
        char[][] map = new char[n][m];
        int[][] dist = new int[n][m];
        for(int i=0; i<n; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                char now = stn.nextToken().charAt(0);
                if(now=='2') {
                    startR = i;
                    startC = j;
                }
                map[i][j] = now;
            }
        }
        
        bfs(startR, startC, n, m, map, dist);
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dist[i][j]==0 && map[i][j]=='1') System.out.print(-1+" ");
                else System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void bfs(int r, int c, int R, int C, char[][] map, int[][] dist) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            
            for(int i=0; i<rDir.length; i++) {
                int nextR = nowR + rDir[i];
                int nextC = nowC + cDir[i];
                
                if(inRange(nextR, nextC, R, C) && map[nextR][nextC]=='1' && dist[nextR][nextC]==0) {
                    dist[nextR][nextC] = dist[nowR][nowC]+1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
    
    public static boolean inRange(int r, int c, int R, int C) {
        return r>=0 && r<R && c>=0 && c<C;
    }
}