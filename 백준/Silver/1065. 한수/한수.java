import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N, result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        result = 0;
        
        if(N<100) {
            result = N;
        } else {
            for(int i=100; i<=N; i++) {
                if(getDiff(String.valueOf(i).toCharArray())) result++;
            }
            result+=99;
        }
        
        System.out.println(result);
    }
    
    // 입력 조건: 세자릿수 숫자
    public static boolean getDiff(char[] num) {
        
        int firstDiff = (num[1]-'0') - (num[0]-'0'); // 둘째자리 - 첫째자리
        int secondDiff = (num[2]-'0') - (num[1]-'0'); // 셋째자리 - 둘째자리
        
        return firstDiff==secondDiff;
    }
    
}