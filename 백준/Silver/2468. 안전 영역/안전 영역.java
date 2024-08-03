import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        
        int maxHeight = 0;
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int height = Integer.parseInt(stn.nextToken());
                map[i][j] = height;
                maxHeight = Math.max(maxHeight, height);
            }
        }
        
        int maxNumOfSafeArea = 0;
        for(int i=0; i<=maxHeight; i++) {
            boolean[][] isVisited = new boolean[N][N];
            int numOfSafeArea = 0;
            
            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if(!isVisited[j][k]&&map[j][k]>i) {
                        numOfSafeArea++;
                        isVisited[j][k] = true;
                        bfs(i, j, k, map, isVisited, N);
                    }
                }
            }
            maxNumOfSafeArea = Math.max(maxNumOfSafeArea, numOfSafeArea);
        }
       
        System.out.println(maxNumOfSafeArea);
    }
    
    public static void bfs(int height, int startX, int startY, int[][] map, boolean[][] isVisited, int N) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if(inRange(nextX, nextY, N)&&!isVisited[nextX][nextY]&&map[nextX][nextY]>height) {
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y, int N) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}