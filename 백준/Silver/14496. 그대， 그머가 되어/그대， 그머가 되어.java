import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(stn.nextToken());
        int b = Integer.parseInt(stn.nextToken());
        
        stn = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] replaceList = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            replaceList[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(stn.nextToken());
            int second = Integer.parseInt(stn.nextToken());
            
            replaceList[first].add(second);
            replaceList[second].add(first);
        }
        
        int[] distArray = new int[N+1];
        bfs(a, b, replaceList, distArray, new boolean[N+1]);

        int aToB = distArray[b];
        if(aToB==0 && a!=b) System.out.println(-1);
        else System.out.println(aToB);
    }
    
    public static void bfs(int start, int end, List<Integer>[] replaceList, int[] distArray, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next: replaceList[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    distArray[next] = distArray[now]+1;
                    queue.add(next);
                }
            }
        }
    }
}