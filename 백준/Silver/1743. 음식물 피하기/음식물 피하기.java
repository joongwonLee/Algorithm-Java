import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dr = new int[]{1, 0, -1, 0};
    static int[] dc = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        
        char[][] map = new char[N+1][M+1];
        boolean[][] isVisited = new boolean[N+1][M+1];
        for(int i=0; i<K; i++) {
            stn = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stn.nextToken());
            int c = Integer.parseInt(stn.nextToken());
            map[r][c] = '#';
        }
        
        int maxSize = 0;
        
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(!isVisited[i][j]&&map[i][j]=='#') {
                    maxSize = Math.max(maxSize, bfs(i, j, N, M, map, isVisited));
                }
            }
        }
        
        System.out.println(maxSize);
    }
    
    static int bfs(int startR, int startC, int N, int M, char[][] map, boolean[][] isVisited) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        
        isVisited[startR][startC] = true;
        int size = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];
                
                if(inRange(nextR, nextC, N, M) && !isVisited[nextR][nextC] && map[nextR][nextC] == '#') {
                    isVisited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC});
                    size++;
                }
            }
        }
        
        return size;
    }
    
    static boolean inRange(int r, int c, int N, int M) {
        return r>0 && r<=N && c>0 && c<=M;
    }
}