import java.util.*;
import java.io.*;

public class Main {
    
    static class Transportation {
        String dist;
        int cost;
        
        public Transportation(String dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Transportation> tList = new ArrayList<>();
        int jinjuCost = 0;
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            String dist = stn.nextToken();
            int cost = Integer.parseInt(stn.nextToken());
            
            if(dist.equals("jinju")) {
                jinjuCost = cost;
                System.out.println(jinjuCost);
            }
            
            Transportation t = new Transportation(dist, cost);
            tList.add(t);
        }

        int expensiveCount = 0;
        for(Transportation t: tList) {
            if(t.cost>jinjuCost) expensiveCount++;
        }

        System.out.println(expensiveCount);
    }
}