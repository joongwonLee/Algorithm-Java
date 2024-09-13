import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        int R = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        int[] distArray = new int[N+1];
        for(int i=1; i<=N; i++) {
            if(i==R) continue;
            distArray[i] = -1;
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stn.nextToken());
            int v = Integer.parseInt(stn.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        bfs(R, N, distArray, graph);
        
        for(int i=1; i<=N; i++) {
            System.out.println(distArray[i]);
        }
    }
    
    static void bfs(int start, int N, int[] distArray, List<Integer>[] graph) {
        
        boolean[] isVisited = new boolean[N+1];
        isVisited[start] = true;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            int dist = distArray[now];
            
            for(int next: graph[now]) {
                
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    distArray[next] = dist+1;
                    queue.add(next);
                }
            }
        }
    }
}