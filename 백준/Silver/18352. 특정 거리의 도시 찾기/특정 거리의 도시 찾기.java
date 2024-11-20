import java.util.*;
import java.io.*;

public class Main {
    
    static List<Integer> resultList = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        int X = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stn.nextToken());
            int to = Integer.parseInt(stn.nextToken());
            
            graph[from].add(to);
        }
        
        bfs(X, K, graph, new boolean[N+1], new int[N+1]);
        
        if(resultList.size()==0) {
            System.out.println(-1);
        } else {
            Collections.sort(resultList);
            for(int result: resultList) {
                System.out.println(result);
            }
        }
    }
    
    public static void bfs(int start, int K, List<Integer>[] graph, boolean[] isVisited, int[] distArray) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next: graph[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    int dist = distArray[now]+1;
                    if(dist==K) {
                        resultList.add(next);
                        distArray[next] = dist;
                    } else if(dist>K) {
                        return;
                    } else {
                        distArray[next] = dist;
                    }
                    queue.add(next);
                }
            }
        }
    }
}