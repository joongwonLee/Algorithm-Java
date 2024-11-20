import java.util.*;
import java.io.*;

public class Main {

    static int[] rDir = new int[]{1, 0};
    static int[] cDir = new int[]{0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] gameMap = new int[N+1][N+1];
        boolean[][] isVisited = new boolean[N+1][N+1];
        for(int i=1; i<=N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                gameMap[i][j] = Integer.parseInt(stn.nextToken());
            }
        }

        dfs(1, 1, N, gameMap, isVisited);
        
        if(isVisited[N][N]) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
    
    public static void dfs(int startR, int startC, int N, int[][] gameMap, boolean[][] isVisited) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;

        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            int nowR = now[0];
            int nowC = now[1];

            for(int i=0; i<rDir.length; i++) {
                int nextR = nowR+(gameMap[nowR][nowC]*rDir[i]);
                int nextC = nowC+(gameMap[nowR][nowC]*cDir[i]);

                if(inRange(nextR, nextC, N) && !isVisited[nextR][nextC]) {
                    isVisited[nextR][nextC] = true;
                    stk.add(new int[]{nextR, nextC});
                }
            }
        }
    }
    
    public static boolean inRange(int r, int c, int N) {
        return r>0 && r<=N && c>0 && c<=N;
    } 
}