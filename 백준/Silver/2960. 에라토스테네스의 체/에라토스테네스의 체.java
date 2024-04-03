import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int N, K;
    static boolean[] isVisited;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(stn.nextToken());
        K = Integer.parseInt(stn.nextToken());
        
        isVisited = new boolean[N+1];
        
        for(int i=2; i<=N; i++) {
            if(isVisited[i]) continue;
            for(int j=i; j<=N; j+=i) {
                if(!isVisited[j]) {
                    isVisited[j] = true;
                                    // System.out.print(j+" ");
                if(--K==0) {
                    System.out.println(j);
                    break;
                }
                }
            }
        }
    }
}