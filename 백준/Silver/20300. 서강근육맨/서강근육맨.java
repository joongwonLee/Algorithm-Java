import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer stn = new StringTokenizer(br.readLine());
        List<Long> equipList = new ArrayList<>();
        for(int i=0; i<N; i++) {
            equipList.add(Long.parseLong(stn.nextToken()));
        }
        
        Collections.sort(equipList);
        long result = Long.MIN_VALUE;
        
        if(N%2==0) {
            for(int i=0; i<N/2; i++) {
                long sum = equipList.get(i)+equipList.get(N-i-1);
                result = Math.max(result, sum);
            }
        } else {
            result = equipList.get(N-1);
            for(int i=0; i<(N-1)/2; i++) {
                long sum = equipList.get(i)+equipList.get(N-i-2);
                result = Math.max(result, sum);
            }
        }
        System.out.println(result);
    }
}