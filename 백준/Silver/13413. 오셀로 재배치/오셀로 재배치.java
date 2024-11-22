import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] init = br.readLine().toCharArray();
            char[] target = br.readLine().toCharArray();
            
            int wInitCnt = 0, wTargetCnt = 0, diffCnt = 0;
            int workNum = 0;
            for(int j=0; j<N; j++) {
                char initC = init[j];
                char targetC = target[j];
                
                if(initC=='W') wInitCnt++;
                if(targetC=='W') wTargetCnt++;
                
                if(initC!=targetC) diffCnt++;

                int wDiff = (int)Math.abs(wInitCnt - wTargetCnt);
                workNum = wDiff + (diffCnt-wDiff)/2;
            }
            
            System.out.println(workNum);
        }
    }
}