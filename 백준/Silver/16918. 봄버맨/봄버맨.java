import java.util.*;
import java.io.*;

public class Main {
    
    static int[] rDir = new int[]{1, 0, -1, 0};
    static int[] cDir = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int R = Integer.parseInt(stn.nextToken());
        int C = Integer.parseInt(stn.nextToken());
        int N = Integer.parseInt(stn.nextToken());
        
        char[][] map = new char[R][C];
        int[][] time = new int[R][C];
        for(int i=0; i<R; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(map[i][j]=='O') time[i][j]++;
            }
        }
        
        // 시작 1초 후에는 아무 일도 일어나지 않기 때문에 2부터 시작
        for(int i=2; i<=N; i++) {
            
            for(int r=0; r<R; r++) {
                for(int c=0; c<C; c++) {
                    if(map[r][c]=='O') time[r][c]++;
                }
            }
            
            if(i%2==0) { // 1. 폭탄이 설치되어 있지 않은 곳에 폭탄 설치. 모든 칸이 폭탄임
                for(int r=0; r<R; r++) {
                    for(int c=0; c<C; c++) {
                        if(map[r][c]=='.') map[r][c] = 'O';
                    }
                }
            } else { // 2. 3초 전에 설치한 폭탄 폭발

                List<int[]> removeList = new ArrayList<>();
                for(int r=0; r<R; r++) {
                    for(int c=0; c<C; c++) {
                        if(map[r][c]=='O' && time[r][c] == 3) {
                            map[r][c] = '.';
                            time[r][c] = 0;
                            for(int d=0; d<rDir.length; d++) {
                                int nextR = r+rDir[d];
                                int nextC = c+cDir[d];
                                
                                if(inRange(nextR, nextC, R, C)) {
                                    removeList.add(new int[]{nextR, nextC});
                                }
                            }
                        }
                    }
                }

                for(int[] remove: removeList) {
                    int r = remove[0];
                    int c = remove[1];

                    map[r][c] = '.';
                    time[r][c] = 0;
                }
            }
        }
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    static boolean inRange(int r, int c, int R, int C) {
        return r>=0 && r<R && c>=0 && c<C;
    }
}