import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        int R = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] graph = new List[N+1];
        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(stn.nextToken());
            int nodeB = Integer.parseInt(stn.nextToken());
            
            graph[nodeA].add(nodeB);
            graph[nodeB].add(nodeA);
        }
        
        for(int i=1; i<=N; i++) {
            Collections.sort(graph[i], Comparator.reverseOrder());
        }

        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];
        
        isVisited[R] = true;
        queue.add(R);

        int[] orderArray = new int[N+1];
        int order = 1;
        
        while(!queue.isEmpty()) {
            
            int now = queue.poll();
            orderArray[now] += (order++);
            
            List<Integer> children = graph[now];
            
            for(int child: children) {
                if(isVisited[child]) continue;
                
                isVisited[child] = true;
                queue.add(child);
            }
        }

        for(int i=1; i<=N; i++) {
            System.out.println(orderArray[i]);
        }
    }
}