import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        stn = new StringTokenizer(br.readLine());
        
        int S = Integer.parseInt(stn.nextToken());
        int E = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] teleports = new ArrayList[N+1];
        int[] times = new int[N+1];
        for(int i=1; i<=N; i++) {
            teleports[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());
            
            teleports[x].add(y);
            teleports[y].add(x);
        }

        bfs(S, N, teleports, times, new boolean[N+1]);
        System.out.println(times[E]);
    }
    
    public static void bfs(int start, int N, List<Integer>[] teleports, int[] times, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            int next = now+1;
            visit(now, next, N, queue, times, isVisited);
            
            next = now-1;
            visit(now, next, N, queue, times, isVisited);
            
            for(int teleport: teleports[now]) {
                next = teleport;
                visit(now, next, N, queue, times, isVisited);
            }
        }
    }
    
    public static void visit(int now, int next, int N, Queue<Integer> queue, int[] times, boolean[] isVisited) {
        
        if(inRange(next, N) && !isVisited[next]) {
            isVisited[next] = true;
            times[next] = times[now]+1;
            queue.add(next);
        }
    }
    
    public static boolean inRange(int x, int N) {
        return x>=1 && x<=N;
    }
}