import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dir = new int[]{1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(stn.nextToken());
        int B = Integer.parseInt(stn.nextToken());
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());

        int[] dist = new int[100001];
        bfs(N, M, A, B, new boolean[100001], dist);

        System.out.println(dist[M]);
    }
    
    public static void bfs(int start, int end, int A, int B, boolean[] isVisited, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            int next = 0;
            
            for(int i=0; i<dir.length; i++) {
                next = now+dir[i];
                visit(next, now, isVisited, dist, queue);
            }
            
            for(int i=0; i<dir.length; i++) {
                next = now+(A*dir[i]);
                visit(next, now, isVisited, dist, queue);
            }
            
            for(int i=0; i<dir.length; i++) {
                next = now+(B*dir[i]);
                visit(next, now, isVisited, dist, queue);
            }
            
            next = now*A;
            visit(next, now, isVisited, dist, queue);
            next = now*B;
            visit(next, now, isVisited, dist, queue);
        }
    }

    public static void visit(int next, int now, boolean[] isVisited, int[] dist, Queue<Integer> queue) {
        if(inRange(next) && !isVisited[next]) {
            isVisited[next] = true;
            dist[next] = dist[now] + 1;
            queue.add(next);
        }
    }
    
    public static boolean inRange(int pos) {
        return pos>=0 && pos<=100000;
    }
}