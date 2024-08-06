import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(stn.nextToken());
        int C = Integer.parseInt(stn.nextToken());
        
        char[][] map = new char[R][C];
        boolean[][] isVisited = new boolean[R][C];
        
        int totalNumOfWolves = 0;
        int totalNumOfSheep = 0;
        
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(!isVisited[i][j] && map[i][j] != '#') {
                    isVisited[i][j] = true;
                    int[] numOfAnimals = bfs(i, j, R, C, map, isVisited);
                    totalNumOfWolves += numOfAnimals[0];
                    totalNumOfSheep += numOfAnimals[1];
                }
            }
        }
        
        System.out.println(totalNumOfSheep+" "+totalNumOfWolves);
    }
    
    public static int[] bfs(int startX, int startY, int R, int C, char[][] map, boolean[][] isVisited) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        int numOfWolves = 0;
        int numOfSheep = 0;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            char c = map[now[0]][now[1]];
            if(c=='v') numOfWolves++;
            else if(c== 'k') numOfSheep++;
            
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if(inRange(nextX, nextY, R, C) && !isVisited[nextX][nextY] && map[nextX][nextY] != '#') {
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        if(numOfSheep>numOfWolves) numOfWolves = 0;
        else numOfSheep = 0;
        
        return new int[]{numOfWolves, numOfSheep};
    }
    
    public static boolean inRange(int x, int y, int R, int C) {
        return x>=0 && x<R && y>=0 && y<C;
    }
}