import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(stn.nextToken());
        int S = Integer.parseInt(stn.nextToken());
        int G = Integer.parseInt(stn.nextToken());
        int U = Integer.parseInt(stn.nextToken());
        int D = Integer.parseInt(stn.nextToken());

        if(S==G) {
            System.out.println(0);
            return;
        }
        
        int[] moveNum = new int[F+1];
        bfs(S, G, U, D, F, moveNum, new boolean[F+1]);
    
        
        int minButtonCount = moveNum[G];
        if(minButtonCount==0) System.out.println("use the stairs");
        else System.out.println(minButtonCount);
    }
    
    public static void bfs(int start, int end, int up, int down, int floor, int[] moveNum, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            int next = now+up;
            move(now, next, floor, queue, moveNum, isVisited);
            next = now-down;
            move(now, next, floor, queue, moveNum, isVisited);
        }
    }
    
    public static void move(int now, int next, int floor, Queue<Integer> queue, int[] moveNum, boolean[] isVisited) {
        if(inRange(next, floor) && !isVisited[next]) {
            isVisited[next] = true;
            queue.add(next);
            if(now!=next) moveNum[next] = moveNum[now]+1;
        }
    }
    
    public static boolean inRange(int x, int floor) {
        return x>=1 && x<=floor;
    }
}