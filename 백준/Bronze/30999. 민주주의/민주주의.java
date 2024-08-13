import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        int agreementNum = 0;
        
        while(N-->0) {
            
            char[] yesOrNo = br.readLine().toCharArray();
            
            int yesNum = 0;
            int noNum = 0;
            
            for(int i=0; i<M; i++) {
                if(yesOrNo[i]=='O') yesNum++;
                else noNum++;
            }
            
            if(yesNum>noNum) agreementNum++;
        }
        
        System.out.println(agreementNum);
    }
}