import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        char[][] map = new char[N][M];
        
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        int startX = 0;
        int startY = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]=='I') {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        Stack<int[]> stk = new Stack<>();
        boolean[][] isVisited = new boolean[N][M];
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        stk.push(new int[]{startX, startY});
        int meetNum = 0;
        
        isVisited[startX][startY] = true;
        
        while(!stk.isEmpty()) {
            
            int[] now = stk.pop();
            int nowX = now[0];
            int nowY = now[1];
            
            //if(isVisited[nowX][nowY]) continue;
            //isVisited[nowX][nowY] = true;
            
            for(int i=0; i<4; i++) {
                int nextX = nowX+dx[i];
                int nextY = nowY+dy[i];
                
                if(inRange(nextX, nextY, N, M) && !isVisited[nextX][nextY] && map[nextX][nextY] != 'X') {
                    if(map[nextX][nextY]=='P') meetNum++;
                    isVisited[nextX][nextY] = true;
                    stk.push(new int[]{nextX, nextY});
                }
            }
        }
        
        if(meetNum==0) System.out.println("TT");
        else System.out.println(meetNum);
    }
    
    static boolean inRange(int x, int y, int N, int M) {
        return x>=0 && x<N && y>=0 && y<M;
    }
}