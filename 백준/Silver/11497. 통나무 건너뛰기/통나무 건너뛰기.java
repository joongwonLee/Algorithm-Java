import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer stn = new StringTokenizer(br.readLine());
            List<Integer> logList = new ArrayList<>();
            for(int i=0; i<N; i++) {
                logList.add(Integer.parseInt(stn.nextToken()));
            }
            
            Collections.sort(logList);
            int[] logArray = new int[N];
            for(int i=0; i<N/2; i++) {
                logArray[i] = logList.get(i*2);
                logArray[N-i-1] = logList.get(i*2+1);
            }
            if(N%2!=0) logArray[N/2] = logList.get(N-1);

            int result = Integer.MIN_VALUE;
            for(int i=0; i<N-1; i++) {
                result = Math.max(result, Math.abs(logArray[i]-logArray[i+1]));
            }

            System.out.println(result);
        }
    }
}