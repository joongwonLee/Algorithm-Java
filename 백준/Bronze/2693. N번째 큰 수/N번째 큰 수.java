import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static int T;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            stn = new StringTokenizer(br.readLine());
            List<Integer> numList = new ArrayList<>();
            
            for(int j=0; j<10; j++) {
                int num = Integer.parseInt(stn.nextToken());
                numList.add(num);
            }
            
            Collections.sort(numList, Comparator.reverseOrder());
            System.out.println(numList.get(2));
        }
    }
}