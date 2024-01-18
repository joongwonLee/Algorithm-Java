import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static int N;
    static boolean[] isNotPrimeNum;
    static long[] dpTable;
    static ArrayList<Integer> primeNums;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
    }

    /**
     * 1. 에라토스테네스의 채로 소수 판별
     * 2. 1~N까지 수 중 소수 거르고
     * 3. 소수 화폐를 이용해 dpTable 갱신
     */
    static void solve() {

        // 1. 소수 판별하고
        calcPrimeNum();

        primeNums = new ArrayList<>();

        dpTable = new long[N+1];
        dpTable[0] = 1;

        // 2. 1~N까지 소수 거르고,
        for(int i=2; i<=N; i++) {
            if(!isNotPrimeNum[i]) primeNums.add(i);
        }

        // 3. 소수 화폐를 돌면서 dpTable 갱신 (화폐를 무제한으로 쓸 수 있으므로 1차원 dp로 해결 가능)
        for(int i=0; i<primeNums.size(); i++) {

            int primeCoin = primeNums.get(i);

            for(int j=primeCoin; j<=N; j++) {
                dpTable[j] = (dpTable[j] + dpTable[j-primeCoin])%123456789;
            }
        }

    }

    // 에라토스테네스의 채를 이용해 N까지의 수를 소수 판별
    static void calcPrimeNum() {

        isNotPrimeNum = new boolean[N+1];

        isNotPrimeNum[0] = true;
        isNotPrimeNum[1] = true;

        for(int i=2; i<=Math.sqrt(N); i++) {

            if(isNotPrimeNum[i]) continue;

            for(int j=i*2; j<=N; j+=i) {
                isNotPrimeNum[j] = true;
            }
        }
    }

    static void output() {
        System.out.println(dpTable[N]);
    }

}
