import java.util.*;
import java.io.*;

public class Main {
    
    static class Wrestler implements Comparable<Wrestler> {
        int num;
        int power;
        int ringPower;
        
        public Wrestler(int num, int power, int ringPower) {
            this.num = num;
            this.power = power;
            this.ringPower = ringPower;
        }
        
        @Override
        public int compareTo(Wrestler w) {
            int myTotalPower = power + ringPower*w.power;
            int yourTotalPower = w.power + w.ringPower*power;
            
            return yourTotalPower - myTotalPower;
        }
    } 
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Wrestler>  wQueue = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int power = Integer.parseInt(stn.nextToken());
            int ringPower = Integer.parseInt(stn.nextToken());
            
            wQueue.add(new Wrestler(i+1, power, ringPower));
        }

        while(!wQueue.isEmpty()) {
            Wrestler w = wQueue.poll();
            System.out.println(w.num);
        }
    }
}