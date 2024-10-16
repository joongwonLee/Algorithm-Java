import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String input = br.readLine();
            if(input.equals("0")) break;
            
            StringTokenizer stn = new StringTokenizer(input);
            
            int K = Integer.parseInt(stn.nextToken());
            int [] lottos = new int[K];
            for(int i=0; i<K; i++) {
                lottos[i] = Integer.parseInt(stn.nextToken());
            }
            combination(lottos, new boolean[K], 0, K, 6);
            System.out.println();
        }
    }


    static void combination(int[] lottos, boolean[] visited, int start, int K, int num) {

        if(num==0) {

            for(int i=0; i<K; i++) {
                if(visited[i]) {
                    System.out.print(lottos[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        
        for(int i=start; i<K; i++) {
            visited[i] = true;
            combination(lottos, visited, i+1, K, num-1);
            visited[i] = false;
        }
    }
}