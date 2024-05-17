import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int M = Integer.parseInt(br.readLine());
        int[] posArray = new int[4]; // 번호에 따른 컵의 위치, int[1]은 1번 컵의 위치
        
        for(int i=1; i<=3; i++) {
            posArray[i] = i;
        }
        
        for(int i=0; i<M; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());
            
            int tmp = posArray[y];
            posArray[y] = posArray[x];
            posArray[x] = tmp;
        }
        
        for(int i=1; i<=3; i++) {
            if(posArray[i]==1) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println(-1);
    }
}