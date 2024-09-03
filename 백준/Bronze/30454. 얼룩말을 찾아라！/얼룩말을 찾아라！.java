import java.util.*;
import java.io.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int L = Integer.parseInt(stn.nextToken());
        
        int[] blackCountArray = new int[L+1];

        int max = 0;
        int maxCount = 0;
        
        for(int i=0; i<N; i++) {
            
            char[] horse = br.readLine().toCharArray();
            int blackCount = 0;
            for(int j=0; j<L; j++) {
                if(horse[j]=='1') {
                    if(j==0) blackCount++;
                    else if(horse[j-1]=='0') blackCount++;
                }
            }
            if(blackCount>max) {
                max = blackCount;
                maxCount = 1;
            } else if(blackCount==max) {
                maxCount++;
            }
        }

        System.out.println(max+" "+maxCount);
        
        // for(int i=L; i>0; i--) {
        //     if(blackCountArray[i]!=0) {
        //         System.out.println(i+" "+blackCountArray[i]);
        //         return;
        //     }
        // }
        
        // System.out.println("0 0");
    }
}