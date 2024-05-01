import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    static int N, contFlag, totalPoint;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        contFlag = 0; totalPoint = 0;
        
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int point = Integer.parseInt(stn.nextToken());
            if(point==0) {
                contFlag = 0;
            } else {
                contFlag++;
                totalPoint+=contFlag;
            }
        }
        
        System.out.println(totalPoint);
    }
}