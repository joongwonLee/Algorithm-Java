import java.util.*;
import java.io.*;

public class Main {
    
    static int[] rDir = new int[]{1, 0, -1, 0};
    static int[] cDir = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(stn.nextToken());
        int m = Integer.parseInt(stn.nextToken());
        
        int startR = 0, startC = 0;
        int[][] infoIsland = new int[n][m];
        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<m; j++) {
                int info = Integer.parseInt(String.valueOf(input.charAt(j)));
                infoIsland[i][j] = info;
                if(info==2) {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        int[][] distArray = new int[n][m];
        bfs(startR, startC, n, m, infoIsland, distArray, new boolean[n][m]);
        
        int result = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                int info = infoIsland[i][j];
                if((info==3||info==4||info==5)&&distArray[i][j]!=0) result = Math.min(result, distArray[i][j]);
            }
        }
        
        if(result==0||result==Integer.MAX_VALUE) System.out.println("NIE");
        else System.out.println("TAK\n"+result);
    }
    
    public static void bfs(int startR, int startC, int n, int m, int[][] infoIsland, int[][] distArray, boolean[][] isVisited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowR = now[0];
            int nowC = now[1];
            
            for(int i=0; i<rDir.length; i++) {
                int nextR = nowR+rDir[i];
                int nextC = nowC+cDir[i];
                
                if(inRange(nextR, nextC, n, m) && !isVisited[nextR][nextC] && infoIsland[nextR][nextC]!=1) {
                    isVisited[nextR][nextC] = true;
                    distArray[nextR][nextC] = distArray[nowR][nowC]+1;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }
    }
    
    public static boolean inRange(int r, int c, int n, int m) {
        return r>=0 && r<n && c>=0 && c<m;
    }
}