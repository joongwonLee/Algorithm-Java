import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        StringBuffer sb1 = new StringBuffer();
        for(int i=0; i<N; i++) {
            sb1.append(stn.nextToken());
        }
        
        stn = new StringTokenizer(br.readLine());
        StringBuffer sb2 = new StringBuffer();
        for(int i=0; i<N; i++) {
            sb2.append(stn.nextToken());
        }
        
        long X = Long.parseLong(sb1.toString());
        long Y = Long.parseLong(sb2.toString());
        
        if(X>=Y) System.out.println(Y);
        else System.out.println(X);
    }
}