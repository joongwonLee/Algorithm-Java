import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int K = Integer.parseInt(stn.nextToken());
        
        List<Integer> divList = new ArrayList<>();
        for(int i=1; i*i<=N; i++) {
            if(N%i==0) {
                divList.add(i);
                if(i*i!=N) divList.add(N/i);
            }
        }
        
        Collections.sort(divList);

        if(divList.size()<K) System.out.println(0);
        else System.out.println(divList.get(K-1));
    }
}