import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] heightOfBalloon;

    static int numOfArrow;

    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    /**
     * 데이터의 크기가 최대 1,000,000이기 때문에, N^2의 형태 이상으로는 풀이 불가
     * 입력을 받는 동시에 결과값을 도출할 수 있는 로직이 필요
     *
     * 풍선의 최대 높이: 1,000,000
     * 1. 풍선의 높이 별 화살의 정보를 담는 배열 생성 (heightOfBalloon)
     * 2. 입력을 받으면서 입력받은 높이 + 1에 화살이 지나가는지 체크
     *  2-1. 만약 높이+1에 화살이 없다면 -> 현재 높이에 화살 체크, 화살 개수 + 1
     *  2-2. 높이+1에 화살이 있다면 -> 높이+1 화살을 빼주고, 현재 높이에 화살 체크
     */
    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        stn = new StringTokenizer(br.readLine());

        heightOfBalloon = new int[1000002];
        numOfArrow = 0;

        for(int i=0; i<N; i++) {
            int balloon = Integer.parseInt(stn.nextToken());

            if(heightOfBalloon[balloon + 1] == 0) {

              heightOfBalloon[balloon] ++;
              numOfArrow ++;
            } else {
                heightOfBalloon[balloon + 1] --;
                heightOfBalloon[balloon] ++;
            }
        }
    }

//    static void solve() {
//
//        numOfArrow = 0;
//
//        /**
//         * 화살을 하나씩 쏘면서 풍선 데이터를 없애는 방식
//         *
//         * 1. 풍선이 없을때 까지 화살 쏘는 것 반복
//         * 2. 화살 쏘기
//         *  2-1. 화살 높이를 지정하고 쏘기
//         *  2-2. 풍선 데이터를 순회하며 화살 높이와 같은 풍선은 터뜨리고 화살의 높이-1
//         */
//        while(balloons.size()!=0) {
//
//            numOfArrow++;
//            int arrowHeight = balloons.get(0);
//            // 터뜨릴 풍선을 arrayList에 담아두는 이유: 바로 삭제하면 arrayList를 순회하는 과정에서 꼬일 수 있기 때문
//            // 모두 순회하고 -> 한번에 balloons에서 제거
//            ArrayList<Integer> burstBalloons = new ArrayList<>();
//
//            for(int i=0; i<balloons.size(); i++) {
//
//                if(arrowHeight == balloons.get(i)) {
//                    arrowHeight--;
//                    burstBalloons.add(i);
//                }
//            }
//
//            // 터뜨릴 풍선 인덱스 리스트를 내림차순으로 정렬
//            // balloons라는 arrayList의 첫 인덱스부터 제거하면 순차적으로 삭제하기 어려움
//            Collections.sort(burstBalloons, Collections.reverseOrder());
//
//            for(int burstBalloon: burstBalloons) {
//                balloons.remove(burstBalloon);
//            }
//        }
//    }

    static void output() {
        System.out.println(numOfArrow);
    }
}
