import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T;
    static int n;

    static int[] dpTable;
    static int cnt; // dpTable를 갱신할 시점을 기록하는 int형 데이터


    /**
     *     최대 입력 데이터인 10000까지 dpTable을 한 번만 갱신하면 되기 때문에
     *     오랜 만에 input, solve, output을 나누지 않고, main에 한 번에 코드 작성 !
      */
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        dpTable = new int[10001];
        // dpTable[0]은 이전 dpTable을 참고하여 갱신하는 방식때문에 1로 초기화해줘야 함 
        dpTable[0] = 1;

        // 입력 받기 전에 dpTable을 다 셋팅
        // 1,2,3의 합으로 이루어진 갯수를 찾는 것
        for(int i=1; i<=3; i++) {

            // 각 dpTable에 대해 1,2,3 이전의 dpTable + 1의 방식으로 갱신
            for(int j=1; j<=10000; j++) {
                if(j<i) continue;
                dpTable[j] += dpTable[j-i];
            }
        }

        for(int i=0; i<T; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(dpTable[n]);
        }
    }

}
