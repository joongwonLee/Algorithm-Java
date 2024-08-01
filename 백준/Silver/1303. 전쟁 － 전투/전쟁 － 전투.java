import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        char[][] warriors = new char[M][N];
        boolean[][] isVisited = new boolean[M][N];
        
        for(int i=0; i<M; i++) {
            warriors[i] = br.readLine().toCharArray();
        }
        
        int myPowerSum = 0;
        int yourPowerSum = 0;
        
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j]) {
                    int power = getSumOfPower(i, j, warriors[i][j], N, M, warriors, isVisited);
                    if(warriors[i][j]=='W') myPowerSum += Math.pow(power, 2);
                    else yourPowerSum += Math.pow(power, 2);
                }
            }
        }
        
        System.out.println(myPowerSum+" "+yourPowerSum);
    }
    
    public static int getSumOfPower(int startX, int startY, char color, int N, int M, char[][] warriors, boolean[][] isVisited) {
        Stack<int[]> stk = new Stack<>();
        stk.add(new int[]{startX, startY});
        
        isVisited[startX][startY] = true;
        int power = 1;
        
        while(!stk.isEmpty()) {
            int[] now = stk.pop();
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if(inRange(nextX, nextY, N, M) && !isVisited[nextX][nextY] && warriors[nextX][nextY]==color) {
                    isVisited[nextX][nextY] = true;
                    stk.add(new int[]{nextX, nextY});
                    power++;
                }
            }
        }
        
        return power;
    }
    
    public static boolean inRange(int x, int y, int N, int M) {
        return x>=0 && x<M && y>=0 && y<N;
    }
}