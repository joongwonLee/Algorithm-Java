import java.util.*;
import java.io.*;

public class Main {

    static int[] rDir = new int[]{1, 0, -1, 0};
    static int[] cDir = new int[]{0, 1, 0, -1};

    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        int[][] originPixels = new int[N][3*M];
        int[][] newPixels = new int[N][M];
        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<3*M; j++) {
                originPixels[i][j] = Integer.parseInt(stn.nextToken());
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                double newPixel = 0.0;
                
                int R = originPixels[i][j*3];
                int G = originPixels[i][j*3+1];
                int B = originPixels[i][j*3+2];
                
                newPixel = (double)(R+G+B)/3;
                
                newPixels[i][j] = (newPixel>=T) ? 255 : 0; 
            }
        }

        boolean[][] isVisited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(newPixels[i][j]==255 && !isVisited[i][j]) {
                    dfs(i, j, N, M, newPixels, isVisited);
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void dfs(int startR, int startC, int N, int M, int[][] newPixels, boolean[][] isVisited) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;

        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            int nowR = now[0];
            int nowC = now[1];

            for(int i=0; i<rDir.length; i++) {
                int nextR = nowR + rDir[i];
                int nextC = nowC + cDir[i];

                if(inRange(nextR, nextC, N, M) && !isVisited[nextR][nextC] && newPixels[nextR][nextC]==255) {
                    isVisited[nextR][nextC] = true;
                    stk.add(new int[]{nextR, nextC});
                }
            }
        }
    }

    public static boolean inRange(int r, int c, int N, int M) {
        return r>=0 && r<N && c>=0 && c<M;
    }
}