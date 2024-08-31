import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        char[] inputArray = br.readLine().toCharArray();
        
        StringBuffer sb = new StringBuffer();
        int tmp = 0;
        
        while(tmp<=inputArray.length-1) {
            
            sb.append(String.valueOf(inputArray[tmp]));
            tmp+=K;
        }
        
        System.out.println(sb);
    }
}