import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    static int N, M;
    
    static char[][] map;
    static boolean[][] isVisited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());
        
        map = new char[N][M];
        isVisited = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int bottomSheet = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!isVisited[i][j]) {
                    dfs(i, j);
                    isVisited[i][j] = true;
                    bottomSheet++;
                }
            }
        }
        
        System.out.println(bottomSheet);
    }
    
    public static void dfs(int startX, int startY) {
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{startX, startY});
        
        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            int nowX = now[0];
            int nowY = now[1];
            char sheet = map[nowX][nowY];
            
            for(int i=0; i<4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                
                if(inRange(nextX, nextY) && !isVisited[nextX][nextY]) {
                    char nextSheet = map[nextX][nextY];
                    if((nowX==nextX && sheet=='-' && nextSheet=='-')
                      || 
                      (nowY==nextY && sheet=='|' && nextSheet=='|')) {
                        stk.push(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}