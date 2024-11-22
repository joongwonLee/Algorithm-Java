import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int[] heightArray = new int[N];
        for(int i=1; i<=N; i++) {
            int comp = Integer.parseInt(stn.nextToken());
            int highCnt = 0;
            for(int j=0; j<N; j++) {
                if(highCnt==comp && heightArray[j]==0) {
                    heightArray[j] = i;
                    break;
                }
                
                if(heightArray[j]==0) highCnt++;
            }
        }
        
        for(int i=0; i<N; i++) {
            System.out.print(heightArray[i]+" ");
        }
    }
}