import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int n, m;
    static Long[] cards;

    static Long result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stn.nextToken());
        m = Integer.parseInt(stn.nextToken());

        cards = new Long[n];

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            cards[i] = Long.parseLong(stn.nextToken());
        }
    }

    static void solve() {

        /**
         * m번 만큼 카드 놀이
         * 1. 카드를 오름차순으로 정렬
         *  1-1. 마지막 결과가 가장 작아야 하기 때문에 가장 작은 카드만으로 게임을 진행
         * 2. 카드의 첫번째와 두번째를 더해 카드놀이
         * 3. (1,2번) m번 만큼 반복
         */
        for(int i=0; i<m; i++) {
            Arrays.sort(cards);

            Long sum = cards[0] + cards[1];
            cards[0] = sum; cards[1] = sum;
        }

        result = 0L;
        for(Long card: cards) result += card;
    }

    static void output() {
        System.out.println(result);
    }
}
