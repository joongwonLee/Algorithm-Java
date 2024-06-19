import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        for(int i=0; i<N; i++) {
            char[] chArray = br.readLine().toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int j=M-1; j>=0; j--) {
                sb.append(chArray[j]);
            }
            System.out.println(sb);
        }
    }
}