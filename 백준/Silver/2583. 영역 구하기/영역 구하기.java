import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[][] map;
    static boolean[][] isVisited;
    
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(stn.nextToken());
        int N = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        
        map = new boolean[M][N];
        isVisited = new boolean[M][N];
        
        for(int i=0; i<K; i++) {
            stn = new StringTokenizer(br.readLine());
            
            int x1 = Integer.parseInt(stn.nextToken());
            int y1 = Integer.parseInt(stn.nextToken());
            int x2 = Integer.parseInt(stn.nextToken());
            int y2 = Integer.parseInt(stn.nextToken());
            
            for(int j=x1; j<x2; j++) {
                for(int k=y1; k<y2; k++) {
                    map[k][j] = true;
                }
            }
        }
        
        int numOfZone = 0;
        List<Integer> zoneList = new ArrayList<>();
        
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!isVisited[i][j] && !map[i][j]) {
                    isVisited[i][j] = true;
                    zoneList.add(bfs(i, j, M, N));
                    numOfZone++;
                }
            }
        }
        
        System.out.println(numOfZone);
        Collections.sort(zoneList);
        for(int zone: zoneList) {
            System.out.print(zone+" ");
        }
    }
    
    static int bfs(int startX, int startY, int M, int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        
        int size = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                
                if(inRange(nextX, nextY, M, N) && !isVisited[nextX][nextY] && !map[nextX][nextY]) {
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    size++;
                }
            }
        }
        
        return size;
    }
    
    static boolean inRange(int x, int y, int M, int N) {
        return x>=0 && x<M && y>=0 && y<N;
    }
}