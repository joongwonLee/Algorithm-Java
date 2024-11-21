import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Long> dairyProductList = new ArrayList<>();
        long minCost = 0L;
        for(int i=0; i<N; i++) {
            long cost = Long.parseLong(br.readLine());
            minCost+=cost;
            dairyProductList.add(cost);
        }
      
        Collections.sort(dairyProductList, Comparator.reverseOrder());
        for(int i=0; i<N; i++) {
            if(i%3==2) minCost-=dairyProductList.get(i);
        }
        
        System.out.println(minCost);
    }
}