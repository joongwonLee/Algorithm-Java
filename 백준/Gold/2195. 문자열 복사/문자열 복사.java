import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;

    static String S;
    static ArrayList<Character> PToCharArrList;

    static int minCopyCnt;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        PToCharArrList = new ArrayList<>();
        char[] PToCharArr = br.readLine().toCharArray();

        for(int i=0; i<PToCharArr.length; i++) {
            PToCharArrList.add(PToCharArr[i]);
        }
    }

    /**
     * 1. P를 ArrayList로 만든 데이터가 빌 때까지 반복하여 2번 실행
     * 2. P를 역순으로 순회
     *  2-1. 역순으로 문자열을 붙여가며 S에 포함된 문자열인지 체크
     *      2-1-1. 포함된다면 나중에 제거할 idx를 queue에 추가, 추가로 (i==0일 때) 마지막 남은 문자열일때는 무조건 copy 함수를 써준 것
     *      2-1-2. 포함이 안된다면 idxQueue를 순회하며 P ArrayList에서 제거 
     */
    static void solve() {
        minCopyCnt = 0;

        while(!PToCharArrList.isEmpty()) {

            minCopyCnt++;

            String compStr = "";
            Queue<Integer> idxQueue = new LinkedList<>();

            for(int i=PToCharArrList.size()-1; i>=0; i--) {

                String startStr = String.valueOf(PToCharArrList.get((i)));
                startStr += compStr;

                if(S.contains(startStr)) {

                    idxQueue.offer(i);
                    compStr = startStr;

                    if(i==0) {
                        while(!idxQueue.isEmpty()) {
                            int idx = idxQueue.poll();
                            PToCharArrList.remove(idx);
                        }
                    }
                } else {

                    while(!idxQueue.isEmpty()) {
                        int idx = idxQueue.poll();
                        PToCharArrList.remove(idx);
                    }

                    break;
                }
            }
        }
    }

    static void output() {
        System.out.println(minCopyCnt);
    }
}
