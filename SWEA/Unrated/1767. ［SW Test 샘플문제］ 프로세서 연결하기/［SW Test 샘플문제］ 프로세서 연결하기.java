
import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer stn;
    static StringBuffer sb;

    static int T, N;
    static int[][] mexinos;
    // 입력으로 1이 들어온 core 위치를 담는 list
    static ArrayList<int[]> cores;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int maxWireCnt;
    static int result;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++) {
            sb = new StringBuffer("#"+i+" ");
            input();
            solve();
            output();
        }
    }

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        mexinos = new int[N][N];
        cores = new ArrayList<>();

        for(int i=0; i<N; i++) {
            stn = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                mexinos[i][j] = Integer.parseInt(stn.nextToken());
                // i==0||i==N-1||j==0||j==N-1 일때 즉, 벽에 붙어있을 땐 이미 충전되어 있는 것으로 간주
                if(mexinos[i][j]==1&&(i!=0&&i!=N-1&&j!=0&&j!=N-1)) {
                    cores.add(new int[]{i,j});
                }
            }
        }
    }

    static void solve() {
        maxWireCnt = Integer.MIN_VALUE;
        result = 0;

        recursive(0, 0, 0);
    }

    // checkCnt: 전선을 이으려는 시도 횟수
    // wireCnt: 실제 전선을 이은 횟수
    static void recursive(int order, int wireCnt, int sumOfWires) {

        if(order == cores.size()) {

            if(wireCnt==maxWireCnt) result = Math.min(result, sumOfWires);
            else if(wireCnt>maxWireCnt) {
                result = sumOfWires;
                maxWireCnt = wireCnt;
            }

            return;
        }

        int[] orderedCore = cores.get(order);
        int orderedX = orderedCore[0];
        int orderedY = orderedCore[1];

        for(int flag=0; flag<dx.length; flag++) {
            int len = canConnect(flag, orderedX, orderedY);

            // 0이 아니라는 것은, 전선 연결이 된다는 뜻
            if(len!=0) {
                connectWire(flag, orderedX, orderedY);
                recursive(order+1, wireCnt+1, sumOfWires+len);
                disconnectWire(flag, orderedX, orderedY);
            }
            else {
                recursive(order+1, wireCnt, sumOfWires);
            }
        }

    }

    // 현재 방향에 따른 flag
    // flag가 0이거나, 1이면 위/아래로 이동하는 것
    // flag가 2이거나, 3이면 왼쪽/오른쪽으로 이동하는 것
    // 전선을 연결할 수 없으면 0 반환, 연결할 수 있으면 전선의 길이 반환
    static int canConnect(int flag, int x, int y) {
        int len = 0;

        switch (flag) {
            case 0: {
                for(int i=x+1; i<mexinos.length; i++) {
                    if(mexinos[i][y]==1) return 0;
                    else len++;
                }
                break;
            }
            case 1: {
                for(int i=x-1; i>=0; i--) {
                    if(mexinos[i][y]==1) return 0;
                    else len++;
                }
                break;
            }
            case 2: {
                for(int i=y+1; i<mexinos.length; i++) {
                    if(mexinos[x][i]==1) return 0;
                    else len++;
                }
                break;
            }
            case 3: {
                for(int i=y-1; i>=0; i--) {
                    if(mexinos[x][i]==1) return 0;
                    else len++;
                }
                break;
            }
        }

        return len;
    }


    static void connectWire(int flag, int x, int y) {
        switch (flag) {
            case 0: {
                for(int i=x+1; i<mexinos.length; i++) mexinos[i][y]=1;
                break;
            }
            case 1: {
                for(int i=x-1; i>=0; i--) mexinos[i][y]=1;
                break;
            }
            case 2: {
                for(int i=y+1; i<mexinos.length; i++) mexinos[x][i]=1;
                break;
            }
            case 3: {
                for(int i=y-1; i>=0; i--) mexinos[x][i]=1;
                break;
            }
        }
    }

    // 전선을 끊으면서, 전선의 위치를 0으로 변경
    static void disconnectWire(int flag, int x, int y) {
        switch (flag) {
            case 0: {
                for(int i=x+1; i<mexinos.length; i++) mexinos[i][y]=0;
                break;
            }
            case 1: {
                for(int i=x-1; i>=0; i--) mexinos[i][y]=0;
                break;
            }
            case 2: {
                for(int i=y+1; i<mexinos.length; i++) mexinos[x][i]=0;
                break;
            }
            case 3: {
                for(int i=y-1; i>=0; i--) mexinos[x][i]=0;
                break;
            }
        }
    }

    static boolean inRange(int x, int y) {
        return x>=0&&x<N&&y>=0&&y<N;
    }

    static void output() {
        sb.append(result);
        System.out.println(sb);
    }
}
