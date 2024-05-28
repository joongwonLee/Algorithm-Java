import java.util.*;
import java.io.*;

public class Main {
    
    static class Pos implements Comparable<Pos> {
        int x;
        int y;
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Pos p) {
            if(this.y==p.y) return this.x-p.x;
            else return this.y-p.y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Pos> posList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());
            
            Pos p = new Pos(x,y);
            posList.add(p);
        }
        
        Collections.sort(posList);
        
        for(Pos p: posList) {
            System.out.println(p.x+" "+p.y);
        }
    }
}