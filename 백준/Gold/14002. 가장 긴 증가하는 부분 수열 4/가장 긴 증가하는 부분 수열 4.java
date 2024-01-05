import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] seq;

    static int[] dpTable;
    static ArrayList<Integer>[] dpSeq;

    static int maxLen;
    static ArrayList<Integer> maxLenSeq;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        seq = new int[N];

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(stn.nextToken());
        }
    }

    static void solve() {

        dpTable = new int[N];
        dpSeq = new ArrayList[N];
        for(int i=0; i<N; i++) dpSeq[i] = new ArrayList<>();

        maxLen = Integer.MIN_VALUE;
        maxLenSeq = new ArrayList<>();

        for(int i=0; i<N; i++) {

            dpSeq[i].add(seq[i]);
            dpTable[i] = 1;

            for(int j=0; j<i; j++) {
                if(seq[i]>seq[j]) {
                    if(dpTable[j]+1>dpTable[i]) {
                        dpTable[i] = dpTable[j]+1;
//                        Collections.copy(dpSeq[i], dpSeq[j]);
                        dpSeq[i] = (ArrayList<Integer>) dpSeq[j].clone();
                        dpSeq[i].add(seq[i]);
                    }
                }
            }
            if(dpTable[i]>maxLen) {
                maxLen = dpTable[i];
                maxLenSeq = dpSeq[i];
            }
        }
    }

    static void output() {
        System.out.println(maxLen);

        for(int i=0; i<maxLenSeq.size(); i++) {
            System.out.print(maxLenSeq.get(i));

            if(i!=maxLenSeq.size()-1) System.out.print(" ");
        }
    }
}
