import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int winA = 0;
        int winB = 0;
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(stn.nextToken());
            int pointB = Integer.parseInt(stn.nextToken());
            
            if(pointA > pointB) {
                winA++;
            } else if(pointB > pointA) {
                winB++;
            }
        }
        
        System.out.println(winA+" "+winB);
    }
}