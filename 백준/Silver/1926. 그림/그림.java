import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(stn.nextToken());
        int m = Integer.parseInt(stn.nextToken());
        
        int[][] drawingPaper = new int[n][m];
        boolean[][] isVisited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                drawingPaper[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
        
        int numOfDrawing = 0;
        int maxSize = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!isVisited[i][j]&&drawingPaper[i][j]==1) {
                    numOfDrawing++;
                    maxSize = Math.max(maxSize, bfs(i, j, n, m, drawingPaper, isVisited));
                }
            }
        }
        
        System.out.println(numOfDrawing);
        System.out.println(maxSize);
    }
    
    static int bfs(int startX, int startY, int n, int m, int[][] drawingPaper, boolean[][] isVisited) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        isVisited[startX][startY] = true;
        int size = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if(inRange(nextX, nextY, n, m)&&!isVisited[nextX][nextY]&&drawingPaper[nextX][nextY]==1) {
                    queue.add(new int[]{nextX, nextY});
                    isVisited[nextX][nextY] = true;
                    size++;
                }
            }
        }
        
        return size;
    }
    
    static boolean inRange(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}