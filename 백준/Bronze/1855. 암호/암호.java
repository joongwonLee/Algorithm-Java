import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        
        char[] message = br.readLine().toCharArray();
        int lengthPerK = message.length/k;
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<k; i++) {
            for(int j=0; j<lengthPerK; j++) {
                if(j%2==0) sb.append(String.valueOf(message[(j*k)+i]));
                else sb.append(String.valueOf(message[(j*k)+(k-i-1)]));
            }
        }
        
        System.out.println(sb);
    }
}