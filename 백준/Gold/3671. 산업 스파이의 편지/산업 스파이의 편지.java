
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringBuffer sb;

    static int T;
    static char[] numCharArr;
    static boolean[] isSelected;

//    static boolean[] isNotPrimeNum;
    static boolean[] isChecked;
    static Set<Integer> set;

    static int numOfPrimeNum;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
    }

    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            numCharArr = br.readLine().toCharArray(); // string으로 들어온 입력을 char 배열로 받음

            numOfPrimeNum = 0;
//            isChecked = new boolean[10_000_000]; -> 메모리 초과
            set = new HashSet<>(); // 해당 수가 소수 판별이 됐는지 안됐는지 판별하기 위함

            // 순열 1자리 수부터 최대 자리수까지 다 돌면서 소수 탐색
            for(int j=1; j<=numCharArr.length; j++) {
                permutation(new char[j], new boolean[numCharArr.length+1], 0, j);
            }

            System.out.println(numOfPrimeNum);
        }
    }

    // 입력으로 들어온 숫자 문자열을 순열로 순서 상관 없이 다 뽑아냄
    static void permutation(char[] out, boolean[] isVisited, int cnt, int depth) {

        // 순열로 뽑은 수들을 합쳐 하나의 수로
        if(cnt==depth) {
            String numStr = "";
            for(char num: out) {
                numStr += num;
            }

            int numInt = Integer.valueOf(numStr);
            // 해당 수가 소수이고, 탐색된 적이 없는 수라면 카운트 증가, 탐색 체크
            if(!isPrimeNum(numInt)&&!set.contains(numInt)) {
                numOfPrimeNum++;
                set.add(numInt);
            }

            return;
        }

        // 순열 뽑아내고 순열 함수 재귀호출
        for(int i=0; i<numCharArr.length; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                out[cnt] = numCharArr[i];
                permutation(out, isVisited, cnt+1, depth);
                isVisited[i] = false;
            }
        }
    }


    // 소수 판별 함수
    static boolean isPrimeNum(int n) {

        if(n==0||n==1) return true;

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0) return true;
        }

        return false;
    }

    // 탐색 배열을 따로 만들었기 때문에, 또 천만개의 배열 만드는건 메모리 초과 날 것 같아서 사용 x
//    static void calcPrimeNum() {
//        isNotPrimeNum = new boolean[10_000_000];
//
//        isNotPrimeNum[0] = true; isNotPrimeNum[1] = true;
//
//        for(int i=2; i<=Math.sqrt(10_000_000); i++) {
//
//            if(isNotPrimeNum[i]) continue;
//
//            for(int j=i*2; j<=10_000_000; j+=i) {
//                isNotPrimeNum[i] = true;
//            }
//        }
//    }
}
