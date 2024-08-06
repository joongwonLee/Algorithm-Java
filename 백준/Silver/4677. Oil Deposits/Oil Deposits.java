import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {-1, 0, 1};
    static int[] dy = {-1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(stn.nextToken());
            int n = Integer.parseInt(stn.nextToken());
            
            if(m==0) break;
            
            char[][] map = new char[m][n];
            boolean[][] isVisited = new boolean[m][n];
            int numOfOilDeposits = 0;
            
            for(int i=0; i<m; i++) {
                map[i] = br.readLine().toCharArray();
            }
            
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(!isVisited[i][j] && map[i][j] == '@') {
                        isVisited[i][j] = true;
                        dfs(i, j, m, n, map, isVisited);
                        numOfOilDeposits++;
                    }
                }
            }

            System.out.println(numOfOilDeposits);
        }
    }
    
    public static void dfs(int startX, int startY, int m, int n, char[][] map, boolean[][] isVisited) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[]{startX, startY});
        
        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    
                    if(i==1&&j==1) continue;
                    
                    int nextX = now[0] + dx[i];
                    int nextY = now[1] + dy[j];
                    
                    if(inRange(nextX, nextY, m, n) && !isVisited[nextX][nextY] && map[nextX][nextY] == '@') {
                        stk.add(new int[]{nextX, nextY});
                        isVisited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
    
    public static boolean inRange(int x, int y, int m, int n) {
        return x>=0 && x<m && y>=0 && y<n;
    }
}