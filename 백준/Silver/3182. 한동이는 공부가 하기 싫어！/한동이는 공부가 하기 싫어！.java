import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    
    static int N;
    static int[] nums;
    static boolean[] isVisited;
    static Stack<Integer> stk;
    
    static int result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }
        
        int maxCount = Integer.MIN_VALUE;
        int result = 1;
        
        for(int i=1; i<=N; i++) {
            int cnt = DFS(i);
            
            if(cnt>maxCount) {
                maxCount = cnt;
                result = i;
            }
        }
        
        System.out.println(result);
    }
    
    public static int DFS(int x) {
        isVisited = new boolean[N+1];
        stk = new Stack<>();
        stk.push(x);
        
        int count = 1;
        
        while(!stk.isEmpty()) {
            
            int now = stk.pop();
            count++;

            if(isVisited[now]) continue;
            isVisited[now] = true;
            
            int next = nums[now];
            stk.push(next);
        }
        
        return count;
    }
}