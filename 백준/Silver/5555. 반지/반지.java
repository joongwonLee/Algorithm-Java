import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static int N, includedLength, includeCount;
    static String includedString;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        includedString = br.readLine();
        includedLength = includedString.length();
        
        N = Integer.parseInt(br.readLine());
        includeCount = 0;
        
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            // 체크하려는 문자열은 10글자 이하, 압력 문자열은 10글자이므로 입력 문자열을 2배로 늘려주면 그 안에서 체크 가능 
            input += input; 
            
            for(int j=0; j<10; j++) {
                String sub = input.substring(j, j+includedLength);
                if(sub.equals(includedString)) {
                    includeCount++;
                    break;
                }
            }
        }
        
        System.out.println(includeCount);
    }
}