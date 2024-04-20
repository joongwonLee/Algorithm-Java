import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    static int R,C;
    static List<Kayak> kayakList;
    static int[] rankArray;
    
    static class Kayak implements Comparable<Kayak> {
        int number;
        int distToFinishLine;
        
        public Kayak(int number, int distToFinishLine) {
            this.number = number;
            this.distToFinishLine = distToFinishLine;
        }
        
        @Override
        public int compareTo(Kayak otherKayak) {
            return this.distToFinishLine - otherKayak.distToFinishLine;
        }
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(stn.nextToken());
        C = Integer.parseInt(stn.nextToken());
        
        kayakList = new ArrayList<>();
        
        for(int i=0; i<R; i++) {
            char[] input = br.readLine().toCharArray();
            secondLoop:
            for(int j=input.length-2; j>0; j--) {
                char now = input[j];
                if(now!='.') {
                    Kayak k = new Kayak(now-'0', (C-1)-j);
                    kayakList.add(k);
                    break secondLoop;
                }
            }
        }
        
        Collections.sort(kayakList);
        
        rankArray = new int[10];
        int tmpRank = 0;
        int tmpDist = Integer.MIN_VALUE;
        
        for(int i=0; i<kayakList.size(); i++) {
            Kayak k = kayakList.get(i);
            int number = k.number;
            int dist = k.distToFinishLine;
            int rank = i+1;

            if(tmpDist<dist) {
                tmpDist = dist;
                tmpRank++;
            }
            
            rankArray[number] = tmpRank;
        }
        
        
        for(int i=1; i<=9; i++) {
            System.out.println(rankArray[i]);
        }
    }
}