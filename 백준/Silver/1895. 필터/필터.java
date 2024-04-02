import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int R, C, T;
    static int[][] pixelArray;
    static int result;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());
        
        pixelArray = new int[R][C];
        
        for(int i=0; i<R; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++) {
                int pixel = Integer.parseInt(stn.nextToken());
                pixelArray[i][j] = pixel;
            }
        }
        
        T = Integer.parseInt(br.readLine());
        result = 0;
        
        for(int i=0; i<R-2; i++) {
            for(int j=0; j<C-2; j++) {
                if(medianValue(i, j)>=T) result++;
            }
        }
        
        System.out.println(result);
    }
    
    public static int medianValue(int n, int m) {
        
        List<Integer> filterList = new ArrayList<>();
        
        for(int i=n; i<n+3; i++) {
            for(int j=m; j<m+3; j++) {
                filterList.add(pixelArray[i][j]);
            }
        }
        
        Collections.sort(filterList);
        return filterList.get(4);
    }
}