import java.util.*;
import java.io.*;

public class Main {
    
    static int[] rDir = new int[]{1, 0, -1, 0};
    static int[] cDir = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=1; i<=T; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(stn.nextToken());
            int W = Integer.parseInt(stn.nextToken());
            
            boolean[][] sheeps = new boolean[H][W];
            boolean[][] isVisited = new boolean[H][W];
            
            int numOfGroups = 0;
            
            for(int h=0; h<H; h++) {
                String input = br.readLine();
                for(int w=0; w<W; w++) {
                    sheeps[h][w] = (input.charAt(w)=='#');
                }
            }
            
            for(int h=0; h<H; h++) {
                for(int w=0; w<W; w++) {
                    if(sheeps[h][w] && !isVisited[h][w]) {
                        dfs(h, w, H, W, sheeps, isVisited);
                        numOfGroups++;
                    }
                }
            }  
            System.out.println(numOfGroups);
        }
    }
    
    public static void dfs(int startR, int startC, int H, int W, boolean[][] sheeps, boolean[][] isVisited) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[]{startR, startC});
        isVisited[startR][startC] = true;
        
        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            int nowR = now[0];
            int nowC = now[1];
            
            for(int i=0; i<rDir.length; i++) {
                int nextR = nowR+rDir[i];
                int nextC = nowC+cDir[i];
                
                if(inRange(nextR, nextC, H, W) && !isVisited[nextR][nextC] && sheeps[nextR][nextC]) {
                    stk.add(new int[]{nextR, nextC});
                    isVisited[nextR][nextC] = true;
                }
            }
        }
    }
    
    public static boolean inRange(int r, int c, int H, int W) {
        return r>=0 && r<H && c>=0 && c<W;
    }
}