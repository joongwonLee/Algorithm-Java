import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] farmLoad = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            farmLoad[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(stn.nextToken());
            int B_i = Integer.parseInt(stn.nextToken());
            
            farmLoad[A_i].add(B_i);
            farmLoad[B_i].add(A_i);
        }
        
        int[] dist = new int[N+1];
        bfs(1, farmLoad, new boolean[N+1], dist);
        
        int maxDist = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        int maxCount = 0;
        int minNumOfMaxDist = N;
        
        for(int i=1; i<=N; i++) {
            if(dist[i]==maxDist) {
                maxCount++;
                minNumOfMaxDist = Math.min(minNumOfMaxDist, i);
            }
        }
        
        System.out.println(minNumOfMaxDist+" "+maxDist+" "+maxCount);
    }
    
    public static void bfs(int start, List<Integer>[] farmLoad, boolean[] isVisited, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next: farmLoad[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    dist[next] = dist[now]+1;
                    queue.add(next);
                }
            }
        }
    }
}