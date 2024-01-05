import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] pSeq, sSeq;

    static int[] originCards;
    static int[] copiedCards;

    static int numOfShuffle;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pSeq = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            pSeq[i] = Integer.parseInt(stn.nextToken());
        }

        sSeq = new int[N];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            sSeq[i] = Integer.parseInt(stn.nextToken());
        }
    }

    /**
     * 1. 카드팩 원본과 복사본을 분리 (사이클이 있는지 확인하기 위해)
     * 2. 수열 P 카드팩과 일치할 때 까지 복사본을 셔플 
     *  2-1. 수열 S 값에 따라 복사본 셔플 
     *  2-2. 셔플 후 사이클이 있다면 바로 리턴 
     */
    static void solve() {

        originCards = new int[N];
        for(int i=0; i<N; i++) originCards[i] = i%3;

        copiedCards = Arrays.copyOf(originCards, originCards.length);
        numOfShuffle = 0;

        while(!isMatchP()) {
            copiedCards = shuffleCards();
            numOfShuffle++;

            // 카드를 셔플하다가 처음 기본 카드팩과 같아진다면, 수열 P를 만들 수 없다는 뜻 -> return
            if(haveCycle()) {
                numOfShuffle = -1;
                return;
            }
        }

    }

    // 카드를 수열 S에 맞게 셔플
    static int[] shuffleCards() {
        int[] shuffled = new int[N];

        for(int i=0; i<N; i++) {
            shuffled[i] = copiedCards[sSeq[i]];
        }

        return shuffled;
    }

    // 카드 셔플 방식이 사이클을 가지고 있는지 확인 -> 사이클이 만들어지는 것을 마주친다면 원본 카드팩을 만들 수 x
    static boolean haveCycle() {

        for(int i=0; i<N; i++) {
            if(copiedCards[i]!=originCards[i]) return false;
        }

        return true;
    }

    // 기본 카드팩이 P 수열과 일치하는지 확인
    static boolean isMatchP() {

        for(int i=0; i<N; i++) {
            if(copiedCards[i]!=pSeq[i]) return false;
        }

        return true;
    }


    static void output() {
        System.out.println(numOfShuffle);
    }
}
