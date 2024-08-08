import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int sum = Integer.parseInt(stn.nextToken());
        int diff = Integer.parseInt(stn.nextToken());

        for(int i=0; i<=1000; i++) {
            for(int j=0; j<=1000; j++) {
                if(i+j==sum && Math.abs(i-j)==diff) {
                    System.out.println(Math.max(i, j)+" "+Math.min(i, j));
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}