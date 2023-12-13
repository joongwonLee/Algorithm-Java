import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int testCase;
    static int N, M;

    static Queue<int[]> queue;
    static ArrayList<Integer> arrList;

    // 인덱스 M인 문서가 몇 번째로 출력되는지 카운트하는 수 -> 결과값
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        stn = new StringTokenizer(br.readLine());
        queue = new LinkedList<>();
        arrList = new ArrayList<>();
        for(int i=0; i<N; i++) {

            int input = Integer.parseInt(stn.nextToken());
            queue.offer(new int[]{i, input});
            arrList.add(input);
        }
    }

    static void solve() {

        Collections.sort(arrList, Collections.reverseOrder());
        cnt = 0;

        while(!queue.isEmpty()) {

            int[] now = queue.poll();

            if(now[1]==arrList.get(0)) {
//                System.out.println("arrList.get(0): "+arrList.get(0) + ", now[1]: "+now[1]);
                arrList.remove(0);
                cnt++;
                if(now[0]==M) return;
            } else {
                queue.offer(now);
            }
        }
    }

    static void output() {
        System.out.println(cnt);
    }
}
