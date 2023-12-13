
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int n;
    static ArrayList<Integer>[] integerTriangle;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        integerTriangle = new ArrayList[n];

        for(int i=0; i<n; i++) integerTriangle[i] = new ArrayList<>();

        for(int i=0; i<n; i++) {
            stn = new StringTokenizer(br.readLine());

            for(int j=0; j<=i; j++) {
                int num = Integer.parseInt(stn.nextToken());
                integerTriangle[i].add(num);
            }
        }
    }

    /**
     * DP (반복문 이용)
     * 1. 정수 삼각형의 밑변으로 이동하면서 각 위치의 데이터를 최대 누적합으로 갱신 
     * 2. 결과값: 밑변의 데이터(누적합) 중 최댓값 
     */
    static void solve() {

        // 밑변 기준으로 위 데이터를 누적합 
        for(int i=1; i<n; i++) {
            
            for(int j=0; j<integerTriangle[i].size(); j++) {
                
                // 밑변 데이터의 인덱스가 0일 때 -> 무조건 바로 위의 데이터를 합 
                if(j==0) {
                    integerTriangle[i].set(j, integerTriangle[i].get(j)+integerTriangle[i-1].get(j));
                    continue;
                }
                
                // 밑변 데이터의 인덱스가 끝일 때 -> 무조건 바로 (위, 왼쪽) 데이터를 합 
                if(j==integerTriangle[i].size()-1) {
                    integerTriangle[i].set(j, integerTriangle[i].get(j)+integerTriangle[i-1].get(j-1));
                    continue;
                }

                // 그게 아니라면, 바로 위 데이터와, (위, 왼쪽) 데이터 중 큰 값을 합 
                int firstComp = integerTriangle[i-1].get(j-1);
                int secondComp = integerTriangle[i-1].get(j);

                int getInt = integerTriangle[i].get(j);
                getInt += Math.max(firstComp, secondComp);
                integerTriangle[i].set(j, getInt);
            }
        }
    }

    static void output() {
        int result = 0;
        for(int sum: integerTriangle[n-1]) result = Math.max(result, sum);

        System.out.println(result);
    }
}
