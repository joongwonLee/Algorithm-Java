import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;
    static int[] sequences;

    static ArrayList<Integer> incList;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        sequences = new int[N];

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            sequences[i] = Integer.parseInt(stn.nextToken());
        }
    }

    /**
     * 기존의 boj11053 가장 긴 증가하는 부분수열의 시간 복잡도: O(N^2)
     * 데이터의 개수가 최대 1,000,000개 들어오는 boj12015에선 O(N^2)은 (1초)시간초과
     * 따라서 하나의 dpTable[i]를 갱신하는 시간 복잡도를 N -> LogN으로 개선해준다면 문제 해결 가능
     *      - (기존) 시간 복잡도 N: 탐색하는 인덱스 i에 대해 i 이전의 값 j를 모두 탐색하며 dpTable[i]를 갱신
     *      - (개선) 시간 복잡도 LogN: 탐색하는 인덱스 i에 대해 이전의 값들 중, 인덱스 i의 값보다 작은 값 중 가장 최신의 인덱스를 찾기
     */
    static void solve() {

        // 증가하는 수열을 담는 list 생성
        incList = new ArrayList<>();
        incList.add(sequences[0]);

        for(int i=1; i<N; i++) {

//            // i 이전의 값을 모두 탐색하면 O(N^2) -> 시간 초과
//            for(int j=0; j<i; j++) {
//                if(sequences[i] > sequences[j]) {
//                    dpTable[i] = Math.max(dpTable[i], dpTable[j]+1);
//                }
//            }

            int endIdx = incList.size()-1;

            // 만약 바로 이전의 값보다 현재 값이 클 때 -> 증가하는 수열의 끝 부분에 추가
            if(sequences[i] > incList.get(endIdx)) {
                incList.add(sequences[i]);
            } else { // 작거나 같을 때, 이분 탐색을 이용해 증가하는 수열의 특정 인덱스에 현재 값을 대체 
                incList.set(binarySearch(sequences[i], endIdx), sequences[i]);
            }
        }
    }

    // 이분 탐색으로 현재의 값보다 작은 값 중 가장 가까운 인덱스를 찾는 함수 
    static int binarySearch(int value, int endIdx) {

        int start = 0;
        int end = endIdx;

        while(start<end) {

            int mid = (start+end)/2;

            // 현재 값이 증가하는 수열의 특정 부분보다 크다면 -> 후반부를 탐색 
            if(value > incList.get(mid)) start = mid+1;
            // 작거나 같다면 -> 전반부를 탐색 
            else end = mid;
        }

        return end;
    }

    static void output() {
        System.out.println(incList.size());
    }
}
