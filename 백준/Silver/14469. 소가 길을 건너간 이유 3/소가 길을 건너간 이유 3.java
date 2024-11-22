import java.util.*;
import java.io.*;

public class Main {
    
    static class CowTime implements Comparable<CowTime> {
        int start;
        int dur;
        
        public CowTime(int start, int dur) {
            this.start = start;
            this.dur = dur;
        }
        
        @Override
        public int compareTo(CowTime ct) {
            return start - ct.start;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<CowTime> ctQueue = new PriorityQueue<>();
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stn.nextToken());
            int dur = Integer.parseInt(stn.nextToken());
            
            ctQueue.add(new CowTime(start, dur));
        }
        
        int time = 0;
        while(!ctQueue.isEmpty()) {
            CowTime ct = ctQueue.poll();
            
            if(time==0) time+=(ct.start+ct.dur);
            else {
                time=(time>ct.start)?(time+ct.dur):(ct.start+ct.dur);
            }
        }
        
        System.out.println(time);
    }
}