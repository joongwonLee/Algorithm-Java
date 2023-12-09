import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int N, L;
    static Puddle[] puddles;

    static int numOfBoard;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stn.nextToken());
        L = Integer.parseInt(stn.nextToken());

        puddles = new Puddle[N];

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(stn.nextToken());
            int end = Integer.parseInt(stn.nextToken());

            puddles[i] = new Puddle(start, end);
        }
    }

    static void solve() {

        // 웅덩이의 출발 지점을 기준으로 오름차순 정렬
        Arrays.sort(puddles);

        // 널빤지 개수 저장하는 데이터 초기화
        numOfBoard = 0;
        // 널빤지의 끝점을 지정할 flag 선언
        int endFlag = puddles[0].start;

        for(Puddle puddle: puddles) {

            int start = puddle.start;
            int end = puddle.end;

            // 널빤지의 끝점보다 현재 물웅덩이의 시작점이 더 뒤라면
            // 널빤지를 새로 깔아야하므로 endFlag를 시작점으로 설정 
            if(start >= endFlag) endFlag = start;

            while(endFlag < end) {
                endFlag += L;
                numOfBoard ++;
            }
        }

    }

    static void output() {
        System.out.println(numOfBoard);
    }
}

// 물웅덩이
class Puddle implements Comparable {

    // 시작점과 끝점
    int start;
    int end;

    public Puddle(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Object o) {
        Puddle p = (Puddle) o;
        return this.start - p.start;
    }
}