import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    static int A, B, result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        A = Integer.parseInt(stn.nextToken());
        B = Integer.parseInt(stn.nextToken());
        result = 0;
        
        int[] getNum = new int[2];
        getNum = getStart(A);
        int startIndex = getNum[0];
        int startNamuji = getNum[1];
        
        for(int i=A; i<=B; i++) {
            result+=startIndex;
            if(++startNamuji>startIndex) {
                startIndex++;
                startNamuji = 1;
            }
        }
        
        System.out.println(result);

    }
    
    public static int[] getStart(int num) {
        
        int index = 1;
        int namuji = 0;
        
        outerLoop:
        while(true) {
            
            if(num==0) break;
            
            // 현재 index만큼 num을 빼주기 
            for(int i=1; i<=index; i++) {
                if(--num==0) {
                    namuji = i;
                    break outerLoop;
                }
            } 
            index++;
        }
        
        return new int[]{index, namuji};
    }
}