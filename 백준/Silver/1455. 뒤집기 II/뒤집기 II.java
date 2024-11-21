import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int M = Integer.parseInt(stn.nextToken());
        
        boolean[][] coins = new boolean[N][M];
        
        for(int i=0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                coins[i][j] = (input.charAt(j)=='0');
            }
        }
        
        int result = 0;
        
        for(int i=N-1; i>=0; i--) {
            for(int j=M-1; j>=0; j--) {
                boolean isFront = coins[i][j];
                if(!isFront) {
                    result++;
                    for(int x=0; x<=i; x++) {
                        for(int y=0; y<=j; y++) {
                            coins[x][y] = !coins[x][y];
                        }
                    }
                }
            }
        }
        
        System.out.println(result);
    }
}