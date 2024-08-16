import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<int[]> pointList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());
            
            pointList.add(new int[]{x, y});
        }
        
        int totalLen = 0;
        
        for(int i=0; i<N; i++) {
            int[] now = pointList.get(i);
            int len = 0;

            
            if(i==N-1) len = Math.abs(now[0]-pointList.get(0)[0]) + Math.abs(now[1]-pointList.get(0)[1]);
            else len = Math.abs(now[0]-pointList.get(i+1)[0]) + Math.abs(now[1]-pointList.get(i+1)[1]);

            totalLen += len;
        }
        
        System.out.println(totalLen);
    }
}