import java.util.*;
import java.io.*;

public class Main {
    
    static int[][] points = {{0, 0, 0}, {0, 0, 1}, {0, 1, 0}, {0, 1, 1}, {1, 0, 0}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}};
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());

            int[] point1 = points[Integer.parseInt(stn.nextToken())];
            int[] point2 = points[Integer.parseInt(stn.nextToken())];
            int[] point3 = points[Integer.parseInt(stn.nextToken())];
            int[] point4 = points[Integer.parseInt(stn.nextToken())];

            if((point1[0]==point2[0]&&point2[0]==point3[0]&&point3[0]==point4[0])
               ||(point1[1]==point2[1]&&point2[1]==point3[1]&&point3[1]==point4[1])
               ||(point1[2]==point2[2]&&point2[2]==point3[2]&&point3[2]==point4[2])) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}