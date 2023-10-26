
import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int N, M;
    static ArrayList<int[]> chickenHouses;
    static ArrayList<int[]> houses;

    static int[] combArr;

    static int minCityChickenDist;

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

        chickenHouses = new ArrayList<>();
        houses = new ArrayList<>();

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int input = Integer.parseInt(stn.nextToken());
                if(input==1) houses.add(new int[]{i,j});
                else if(input==2) chickenHouses.add(new int[]{i,j});
            }
        }
    }

    static void solve() {

        minCityChickenDist = Integer.MAX_VALUE;
        combArr = new int[M];
        ArrayList<Integer> combinationList = new ArrayList<Integer>();

        combination(0, 0);
    }

    static void combination(int cnt, int start) {

        if(cnt==M) {
            int cityChickenDist = 0;

            for(int[] house: houses) cityChickenDist += calcChickenDist(house[0], house[1], combArr);

            minCityChickenDist = Math.min(minCityChickenDist, cityChickenDist);
            return;
        }

        for(int i=start; i<chickenHouses.size(); i++) {
            combArr[cnt] = i;
            combination(cnt+1, i+1);
        }

    }

    static int calcChickenDist(int x, int y, int[] combArr) {

        int minChickenDist = Integer.MAX_VALUE;

        for(int i=0; i<combArr.length; i++) {
            int[] chickenHouse = chickenHouses.get(combArr[i]);

            int chickenDist = Math.abs(x-chickenHouse[0])+Math.abs(y-chickenHouse[1]);
            minChickenDist = Math.min(minChickenDist, chickenDist);
        }

        return minChickenDist;
    }

    static void output() {
        sb = new StringBuffer();
        sb.append(minCityChickenDist);
        System.out.println(sb);
    }
}
