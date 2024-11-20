import java.util.*;
import java.io.*;

public class Main {
    
    //Sol. 작업의 역으로 순회 후, Set으로 담아 그 개수 출력
    
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        List<Integer>[] workSet = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            workSet[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++) {
            stn = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
            
            workSet[B].add(A);
        }
        
        int X = Integer.parseInt(br.readLine());
        dfs(X, workSet, new boolean[N+1]);
        
        System.out.println(set.size());
    }
    
    public static void dfs(int start, List<Integer>[] workSet, boolean[] isVisited) {
        
        Stack<Integer> stk = new Stack<>();
        stk.add(start);
        isVisited[start] = true;
        
        while(!stk.isEmpty()) {
            
            int now = stk.pop();
            
            for(int next: workSet[now]) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    set.add(next);
                    stk.push(next);
                }
            }
        }
    }
}