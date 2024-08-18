import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(stn.nextToken());
        int Y = Integer.parseInt(stn.nextToken());
        int R = Integer.parseInt(stn.nextToken());
        
        int numOfInsidePositionZero = 0;
        int numOfBoundaryPositionZero = 0;
        
        while(N-->0) {
            int T = Integer.parseInt(br.readLine());
            
            if(T>X-R&&T<X+R) numOfInsidePositionZero++;
            else if(T==X-R||T==X+R) numOfBoundaryPositionZero++;
        }
        
        System.out.println(numOfInsidePositionZero+" "+numOfBoundaryPositionZero);
    }
}