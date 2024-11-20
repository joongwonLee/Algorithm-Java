import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        List<Double> drinkList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            drinkList.add(Double.parseDouble(stn.nextToken()));
            //deque.add(Double.parseDouble(stn.nextToken()));
        }
        
        Collections.sort(drinkList);
        Deque<Double> deque = new ArrayDeque<>(drinkList);
                          
        while(deque.size()!=1) {
            double min = deque.pollFirst();
            double max = deque.pollLast();
            
            deque.add(max+min/2);
        }
        
        System.out.println(deque.poll());
    }
}