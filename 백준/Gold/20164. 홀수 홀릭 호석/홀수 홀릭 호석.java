import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static String numStr;

    static int minNumOfOdd;
    static int maxNumOfOdd;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        numStr = br.readLine();
    }

    static void solve() {

        minNumOfOdd = Integer.MAX_VALUE;
        maxNumOfOdd = Integer.MIN_VALUE;

        calcOddOper(numStr, 0);
    }

    // 호석이가 진행하는 하나의 연산
    static void calcOddOper(String num, int numOfOdd) {

        // 숫자가 한 자릿수일 때 -> 홀수 개수의 최소 최대값을 갱신해주고 return
        if(num.length()==1) {
            // 한 자릿수가 홀수이면 홀수 갯수+1
            if(Integer.parseInt(num)%2!=0) numOfOdd++;
            minNumOfOdd = Math.min(minNumOfOdd, numOfOdd);
            maxNumOfOdd = Math.max(maxNumOfOdd, numOfOdd);
            return;
        }

        // 숫자가 두 자릿수일 때 -> 각 자릿수의 합을 새로운 수로
        if(num.length()==2) {
            // 두 자릿수의 각 자릿수의 홀수 개수
            int oddCnt = 0;

            int firstNum = Integer.parseInt(String.valueOf(num.charAt(0)));
            if(firstNum%2!=0) oddCnt++;
            int secondNum = Integer.parseInt(String.valueOf(num.charAt(1)));
            if(secondNum%2!=0) oddCnt++;

            String newNum = String.valueOf(firstNum+secondNum);

            // 홀수 개수를 갱신하여 함수 재귀 호출
            calcOddOper(newNum, numOfOdd+oddCnt);
        }

        // 숫자가 세 자릿수 이상일 떄 -> 수를 세 부분으로 나누어 새로운 수로 (경우의 수를 조합으로)
        if(num.length()>=3) {

            int oddCnt = 0;
            for(int i=0; i<num.length(); i++) {
                int digit = Integer.parseInt(String.valueOf(num.charAt(i)));
                if(digit%2!=0) oddCnt++;
            }

            comb(num, numOfOdd+oddCnt, 0, 1, new int[2]);
        }
    }

    // 수가 세 자릿수 이상일 때 조합을 통해 함수를 재귀호출하는 함수
    // 홀수의 개수(기존 홀수 개수 + 자릿수에 따라 추가되는 홀수 개수)도 인자로 필요
    static void comb(String num, int numOfOdd, int cnt, int start, int[] div) {

        // 구분선 2개를 뽑아야 하므로 cnt 인자가 2일 때 종료
        // 구분선 2개에 따라 수를 나누고 새로운 수를 인자로 하여 calcOddOper 함수 호출
        if(cnt==2) {
            String newNum = "";

            int firstNum = Integer.parseInt(num.substring(0, div[0]));
            int secondNum = Integer.parseInt(num.substring(div[0], div[1]));
            int thirdNum = Integer.parseInt(num.substring(div[1]));

            newNum = String.valueOf(firstNum+secondNum+thirdNum);

            calcOddOper(newNum, numOfOdd);

            return;
        }

        int numLen = num.length();

        for(int i=start; i<numLen; i++) {
            div[cnt] = i;
            comb(num, numOfOdd, cnt+1, i+1, div);
        }
    }

    static void output() {
        System.out.println(minNumOfOdd+" "+maxNumOfOdd);
    }
}
