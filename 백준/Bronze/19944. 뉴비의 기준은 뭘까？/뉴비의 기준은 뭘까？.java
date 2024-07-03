import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        if(M==1||M==2) {
            System.out.println("NEWBIE!");
        } else if(M<=N) {
            System.out.println("OLDBIE!");
        } else {
            System.out.println("TLE!");
        }
        
    }
}