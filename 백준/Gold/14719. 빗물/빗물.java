import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static StringTokenizer stn;

    static int H, W;
    static boolean[][] blocks;

    static int result;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    static void input() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());

        H = Integer.parseInt(stn.nextToken());
        W = Integer.parseInt(stn.nextToken());

        // 입력 데이터를 2차원 boolean 타입 배열로
        blocks = new boolean[W][H];
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            // 들어온 빗물 양만큼 2차원 배열을 true로
            int rainWater = Integer.parseInt(stn.nextToken());
            for(int j=0; j<rainWater; j++) {
                blocks[i][j] = true;
            }
        }

    }

    /**
     * 빗물이 고이는 것을 2차원 배열로 형상화
     * 1. 0부터 블록의 최대 높이만큼 순회하면서 각 층에 쌓인 빗물을 계산
     *  1-1. true는 블록이 있고, false는 블록이 없다는 뜻
     *  1-2. 블록의 유무를 flag로 두면서 true와 true 사이의 빗물 양을 계산
     */
    static void solve() {

        result = 0;

        // 0부터 최대 높이까지 순회 
        for(int i=0; i<H; i++) {
            
            // flag: 블록의 유무
            boolean tag = false;
            // 각 층에서 쌓이는 빗물의 양 
            int amountOfRain = 0;

            // 가로의 길이만큼 돌면서 
            for(int j=0; j<W; j++) {
                
                // 1. 블록이 있는 상태일 때 
                if(tag) {
                    // 1-1. 다음 칸이 블록이라면 -> 쌓여있던 빗물을 결과에 더하고, 빗물을 0으로 초기화
                    if(blocks[j][i]) {
                        result += amountOfRain;
                        amountOfRain = 0;
                    } else { // 1-2. 다음 칸이 블록이 아니라면 -> 빗물의 양을 더해줌 
                        amountOfRain++;
                    }
                } else { // 2. 블록이 없는 상태일 때 
                    // tag는 다음 블록의 상태를 그대로 따라간다. (빗물이 있든 없든 블록이 없는 상태라면 아무 의미가 x)
                    tag = blocks[j][i];
                }
            }
        }
    }

    static void output() {
        System.out.println(result);
    }
}
