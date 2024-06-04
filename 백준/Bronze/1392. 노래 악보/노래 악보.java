import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int Q = Integer.parseInt(stn.nextToken());
        
        int[] timeList = new int[N+1];
        
        for(int i=1; i<=N; i++) {
            int time = Integer.parseInt(br.readLine());
            if(i==1) timeList[i] = time-1;
            else timeList[i] = timeList[i-1]+time;
        }
        
        for(int i=0; i<Q; i++) {
            int requestTime = Integer.parseInt(br.readLine());
            for(int j=1; j<=N; j++) {
                if(requestTime<=timeList[j]) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}