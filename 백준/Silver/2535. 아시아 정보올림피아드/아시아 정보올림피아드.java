import java.util.*;
import java.io.*;

public class Main {
    
    static class Participant implements Comparable<Participant> {
        int nation;
        int student;
        int point;
        
        public Participant(int nation, int student, int point) {
            this.nation = nation;
            this.student = student;
            this.point = point;
        }
        
        @Override
        public int compareTo(Participant p) {
            return p.point - this.point;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] numOfMedalPerNation = new int[N+1];
        ArrayList<Participant> pList = new ArrayList<Participant>();
        
        for(int i=0; i<N; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int nation = Integer.parseInt(stn.nextToken());
            int student = Integer.parseInt(stn.nextToken());
            int point = Integer.parseInt(stn.nextToken());
            
            Participant p = new Participant(nation, student, point);
            pList.add(p);
        }
        
        Collections.sort(pList);
        int rank = 1;
        for(Participant p: pList) {
            int nation = p.nation;
            int student = p.student;
            if(numOfMedalPerNation[nation]<2) {
                numOfMedalPerNation[nation]++;
                System.out.println(nation+" "+student);
                if(++rank>3) break;
            }
        }
    }
}