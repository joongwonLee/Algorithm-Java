import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, M;

    static PriorityQueue<Integer> timesForCharge;
    static PriorityQueue<Integer> sumOfTimesForCharge;

    static int minTime;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        M = Integer.parseInt(stn.nextToken());

        // 우선순위 큐 내림차순 정렬
        timesForCharge = new PriorityQueue<>((Integer o1, Integer o2) -> {
            return o2-o1;
        });

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            timesForCharge.offer(Integer.parseInt(stn.nextToken()));
        }
    }

    /**
     * 우선순위 큐를 활용한 풀이
     * 1. 충전 시간 데이터를 정렬 (내림차순, 오름차순 상관 없을듯..? 단, 정렬 순서에 따라 우선순위 큐 기준도 다르게 할 것)
     * 2. M개의 충전 시간을 우선순위 큐에 offer => M개의 콘센트에 충전
     * 3. (정렬 순서에 따라 다름) 우선순위 큐 기준에 따라 가장 먼저 나온 요소를 pop하고 큐에 들어가지 않은 충전 시간을 더해 우선순위 큐에 offer
     * 4. N개의 전자기기가 모두 우선순위 큐에 들어갔다면, 모두 꺼내 가장 큰 값 출력
     */
    static void solve() {

        // 오름차순 정렬 (작은 순으로 나와야 최소 시간을 구할 수 있기 때문)
        sumOfTimesForCharge = new PriorityQueue<>((Integer o1, Integer o2) ->  {
           return  o1-o2;
        });

        minTime = Integer.MAX_VALUE;

        // 충전기의 개수가 전자기기의 개수보다 많다면, 가장 오래 걸리는 충전 시간이 결과값
        if(N<=M) {
            minTime = timesForCharge.poll();
            return;
        }

        // 첫 M개의 충전기에 전자기기를 충전
        for(int i=0; i<M; i++) {
            sumOfTimesForCharge.offer(timesForCharge.poll());
        }

        // N개의 충전기가 다 충전될 때까지
        // 충전 누적 시간을 우선순위 큐에 offer
        while(!timesForCharge.isEmpty()) {
            int beenCharged = sumOfTimesForCharge.poll();
            sumOfTimesForCharge.offer(timesForCharge.poll()+beenCharged);
        }

        // 마지막에 나오는 값이 결과값
        while(!sumOfTimesForCharge.isEmpty()) {
            minTime = sumOfTimesForCharge.poll();
        }

    }

    static void output() {
        System.out.println(minTime);
    }
}
