import java.util.*;
import java.io.*;

public class Main {
    
    //Set<Integer> invited = new HashSet<>();
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<Integer>[] friendship = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            friendship[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());
            
            friendship[a].add(b);
            friendship[b].add(a);
        }
        
        int[] sangguensFriendship = new int[n+1];
        bfs(1, n, new boolean[n+1], sangguensFriendship, friendship);
        
        System.out.println(result);
    }
    
    public static void bfs(int start, int n, boolean[] isVisited, int[] sangguensFriendship, List<Integer>[] friendship) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
            
            for(int next: friendship[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    sangguensFriendship[next] = sangguensFriendship[now]+1;
                    queue.add(next);
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            if(sangguensFriendship[i]==1 || sangguensFriendship[i]==2) result++;
        }
    }
}