import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(stn.nextToken());
            int N = Integer.parseInt(stn.nextToken());
            int K = Integer.parseInt(stn.nextToken());
            
            boolean[][] map = new boolean[M][N];
            boolean[][] isVisited = new boolean[M][N];
            
            int result = 0;
            
            for(int i=0; i<K; i++) {
                stn = new StringTokenizer(br.readLine());
                
                int X = Integer.parseInt(stn.nextToken());
                int Y = Integer.parseInt(stn.nextToken());
                
                map[X][Y] = true;
            }
            
            for(int i=0; i<M; i++) {
                for(int j=0; j<N; j++) {
                    if(map[i][j]&&!isVisited[i][j]) {
                        result++;
                        isVisited[i][j] = true;
                        bfs(i, j, map, isVisited);
                    }
                }
            }
            
            System.out.println(result);
        }
    }
    
    static void bfs(int startX, int startY, boolean[][] map, boolean[][] isVisited) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if(inRange(nextX, nextY, map.length, map[0].length) && !isVisited[nextX][nextY] && map[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = true;
                }
            }
        }
    }
    
    static boolean inRange(int x, int y, int M, int N) {
        return x>=0 && x<M && y>=0 && y<N;
    }
}