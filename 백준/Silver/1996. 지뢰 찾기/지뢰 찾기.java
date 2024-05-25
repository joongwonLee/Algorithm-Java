import java.util.*;
import java.io.*;

public class Main {
    
    static int[] dx = {1, 0, -1};
    static int[] dy = {1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        char[][] map = new  char[N][N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        
        char[][] result = new char[N][N];
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j]=='.') {
                    result[i][j] = getNumOfBomb(i, j, N, map);
                } else {
                    result[i][j] = '*';
                }
            }
        }
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j]+"");
            }
            System.out.println();
        }
        
    }
    
    public static char getNumOfBomb(int x, int y, int N, char[][] map) {
        
        int sumOfBomb = 0;
        
        for(int i=0; i<dx.length; i++) {
            for(int j=0; j<dy.length; j++) {
                int nextX = x+dx[i];
                int nextY = y+dy[j];
                
                if(inRange(nextX, nextY, N)&&map[nextX][nextY]!='.') {
                    // sumOfBomb += Integer.parseInt(String.valueOf(map[nextX][nextY]));
                    sumOfBomb += map[nextX][nextY]-'0';
                }
            }
        }
        
        if(sumOfBomb>=10) return 'M';
        // else return String.valueOf(sumOfBomb).charAt(0);
        else return (char)(sumOfBomb+'0');
    }
    
    public static boolean inRange(int x, int y, int N) {
        return x>=0&&x<N&&y>=0&&y<N;
    }
}