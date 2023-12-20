import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N;

    static ArrayList<Long> incList;

    public static void main(String[] args) throws IOException {
        inputAndSolve();
        output();
    }

    /**
     * 시간 복잡도: 데이터의 크기만큼 탐색하며 증가하는 수열 탐색 O(N) * 이분 탐색을 통해 증가하는 수열이 들어갈 최적의 위치를 탐색 O(LogN) = O(NLogN)
     */
    static void inputAndSolve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 증가하는 수열을 저장하는 리스트
        incList = new ArrayList<>();

        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {

            // 입력 데이터가 -10억부터 10억이므로 안전하게 Long으로 선언
            Long data = Long.parseLong(stn.nextToken());

            // 초기 데이터는 이전의 데이터가 없으므로 리스트에 add
            if(i==0) {
                incList.add(data);
                continue;
            }

            int endIdx = incList.size()-1;

            // 입력 데이터를 수열 리스트의 마지막과 비교
            // 1. 크다면, 증가하는 수열 리스트의 마지막에 add
            if(data > incList.get(endIdx)) {
                incList.add(data);
            } else { // 2. 작거나 같다면, 이분 탐색 함수를 통해 수열 리스트의 특정 인덱스에 대치
                incList.set(binarySearch(data, endIdx), data);
            }

        }
    }

    // 이분탐색을 통해 증가하는 수열에 대치될 특정 인덱스를 탐색하는 함수
    // 증가하는 수열은 기본적으로 오름차순으로 정렬이 되어있기 때문에 이분 탐색 가능
    static int binarySearch(Long data, int endIdx) {

        int start = 0;
        int end = endIdx;

        while(start<end) {

            int mid = (start+end)/2;

            // data의 값에 대해 증가하는 수열에서 data보다 작은 가장 가까운 인덱스를 찾는 것
            if(data > incList.get(mid)) start = mid+1;
            else end = mid;
        }

        return end;
    }

    static void output() {
        System.out.println(incList.size());
    }
}
