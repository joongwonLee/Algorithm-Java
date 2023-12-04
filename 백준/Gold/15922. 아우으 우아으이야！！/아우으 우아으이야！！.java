import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;

    // 선분의 길이를 저장한 가장 최근 xTag, yTag를 저장
    static int xTag, yTag;

    static int sumOfLines;

    // 입력 받으면서 답을 도출해 낼 수 있는 문제는 main에서 한 번에 코드 작성
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        sumOfLines = 0;
        xTag = 0; yTag = 0;

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(stn.nextToken());
            int y = Integer.parseInt(stn.nextToken());

            // xTag와 yTag를 첫 데이터로 세팅
            if(i==0) {
                xTag = x;
                yTag = y;
                continue;
            }

            if(yTag >= y) {
                continue;
            } else if(yTag >= x) {
                yTag = y;
            } else {
                sumOfLines += (yTag - xTag);
                yTag = y;
                xTag = x;
            }
//
//            /**
//             * 좌표가 들어오는 순서
//             * 1. x가 증가하는 순
//             * 2. x가 같다면 y가 증가하는 순
//             */
//
//            // 1. x가 증가하는 순
//            if(x > xTag) {
//
////                // 해당 조건문에선 xTag는 x로 갱신
////                xTag = x;
//
//                // case1. y > yTag, x > yTag
//                if(y > yTag && x > yTag) {
//                    sumOfLines += (y-x);
//                    yTag = y;
//                    xTag = x;
//                    continue;
//                }
//
//                // case2. y > yTag, x < yTag
//                if(y > yTag && x < yTag) {
//                    sumOfLines += (y-yTag);
//                    yTag = y;
//                    continue;
//                }
//
//                // case3. y <= yTag
//                if(y <= yTag) {
//                    continue;
//                }
//            }
//
//            // 2. x가 같다면 y가 증가하는 순
//            if(x == xTag) {
//                sumOfLines += (y-yTag);
//                yTag = y;
//            }

        }


        sumOfLines += (yTag - xTag);
        System.out.println(sumOfLines);
    }

}
