import java.util.*;
import java.io.*;

public class Main {
    
    static int[] rDir = new int[]{1, 0, -1, 0};
    static int[] cDir = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(stn.nextToken());
        int N = Integer.parseInt(stn.nextToken());
        
        boolean[][] map = new boolean[M][N];
        for(int i=0; i<M; i++) {
            String input = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = input.charAt(j)=='0'; // 전류가 통하면(0) true, 전류가 통하지 않으면(1) false
            }
        }
        
        boolean[][] isVisited = new boolean[M][N];
        for(int i=0; i<N; i++) {
            if(map[0][i]) { // 바깥쪽(첫번째 줄) 중 전류가 통하는 곳에서 그래프 탐색 시작
                dfs(0, i, M, N, map, isVisited);
            }
        }
        
        boolean isPenetrate = false;
        for(int i=0; i<N; i++) {
            if(isVisited[M-1][i]) isPenetrate = true;
        }

        if(isPenetrate) System.out.println("YES");
        else System.out.println("NO");
    }
    
    public static void dfs(int startR, int startC, int M, int N, boolean[][] map, boolean[][] isVisited) {
        Stack<int[]> stk = new Stack<>();
        stk.push(new int[]{startR, startC});
        isVisited[startR][startC] = true;
        
        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            int nowR = now[0];
            int nowC = now[1];
            
            for(int i=0; i<rDir.length; i++) {
               int nextR = nowR + rDir[i];
               int nextC = nowC + cDir[i];
                
               if(inRange(nextR, nextC, M, N) && !isVisited[nextR][nextC] && map[nextR][nextC]) {
                   isVisited[nextR][nextC] = true;
                   stk.push(new int[]{nextR, nextC});
               }
            }
        }
    }
    
    public static boolean inRange(int r, int c, int M, int N) {
        return r>=0 && r<M && c>=0 && c<N;
    }
}