import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Integer>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int g = Integer.parseInt(stn.nextToken());
                if(g==1) {
                    graph[i].add(j);
                }
            }
        }
        
        boolean[][] pathOrNot = new boolean[N][N];
        for(int i=0; i<N; i++) {
            bfs(i, N, graph, pathOrNot);
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(pathOrNot[i][j]) System.out.print(1+" ");
                else System.out.print(0+" ");
            }
            System.out.println();
        }
    }
    
    public static void bfs(int start, int N, List<Integer>[] graph, boolean[][] pathOrNot) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] isVisited = new boolean[N];
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next: graph[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    pathOrNot[start][next] = true;
                    queue.add(next);
                }
            }
        }
    }
}