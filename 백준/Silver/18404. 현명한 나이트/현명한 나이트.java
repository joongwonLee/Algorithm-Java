import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        stn = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(stn.nextToken());
        int Y = Integer.parseInt(stn.nextToken());
        
        int[][] horses = new int[M][2];
        int[][] dist = new int[N+1][N+1];
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
            
            horses[i][0] = A;
            horses[i][1] = B;
        }
        
        bfs(X, Y, N, dist, new boolean[N+1][N+1]);
        
        for(int i=0; i<M; i++) {
            System.out.print(dist[horses[i][0]][horses[i][1]]+" ");
        }
    }
    
    public static void bfs(int startR, int startC, int N, int[][] dist, boolean[][] isVisited) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            
            for(int i=0; i<dir.length; i++) {
                int nextR = nowR + dir[i][0];
                int nextC = nowC + dir[i][1];
                
                if(inRange(nextR, nextC, N) && !isVisited[nextR][nextC]) {
                    isVisited[nextR][nextC] = true;
                    dist[nextR][nextC] = dist[nowR][nowC]+1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
    
    public static boolean inRange(int r, int c, int N) {
        return r>0 && r<=N && c>0 && c<=N;
    }
}