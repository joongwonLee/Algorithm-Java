import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] jump = new int[n+1];
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            jump[i] = Integer.parseInt(stn.nextToken());
        }
        
        int s = Integer.parseInt(br.readLine());
        
        System.out.println(dfs(s, jump, new boolean[n+1], n));
    }
    
    public static int dfs(int start, int[] jump, boolean[] isVisited, int n) {
        Stack<Integer> stk = new Stack<>();
        stk.push(start);
        isVisited[start] = true;
        int count = 1;
        
        while(!stk.isEmpty()) {
            int now = stk.pop();
            
            int next = now+jump[now];
            if(inRange(next, n) && !isVisited[next]) {
                isVisited[next] = true;
                stk.push(next);
                count++;
            }
            next = now-jump[now];
            if(inRange(next, n) && !isVisited[next]) {
                isVisited[next] = true;
                stk.push(next);
                count++;
            }
        }
        return count;
    }
    
    public static boolean inRange(int now, int n) {
        return now>=1 && now<=n;
    }
}