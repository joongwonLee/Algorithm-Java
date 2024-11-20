import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dir = new int[]{-1, 0, 1};
    static int result = Integer.MIN_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        boolean[][] spaces = new boolean[N][M];
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                spaces[i][j] = (Integer.parseInt(stn.nextToken()) == 1);
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!spaces[i][j]) bfs(i, j, N, M, spaces); // 빈 칸에서 BFS 돌리면서 모든 상어와의 거리 구하기
            }
        }
        
        System.out.println(result);
    }
    
    public static void bfs(int startR, int startC, int N, int M, boolean[][] spaces) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        boolean[][] isVisited = new boolean[N][M];
        isVisited[startR][startC] = true;
        int[][] dist = new int[N][M];

        int safeDist = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            
            for(int i=0; i<dir.length; i++) {
                for(int j=0; j<dir.length; j++) {
                    if(dir[i]==0&&dir[j]==0) continue;
                    
                    int nextR = nowR + dir[i];
                    int nextC = nowC + dir[j];
                
                    if(inRange(nextR, nextC, N, M) && !isVisited[nextR][nextC]) {
                        isVisited[nextR][nextC] = true;
                        dist[nextR][nextC] = dist[nowR][nowC] + 1;
                        queue.add(new int[]{nextR, nextC});
                        if(spaces[nextR][nextC]) safeDist = Math.min(safeDist, dist[nextR][nextC]);
                    }
                }
            }
        }

       // System.out.println("startR: "+startR+", startC: "+startC+", safeDist: "+safeDist);

        result = Math.max(result, safeDist);
    }
    
    public static boolean inRange(int r, int c, int N, int M) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}