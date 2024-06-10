import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int L = Integer.parseInt(stn.nextToken());
        
        List<Integer> heightList = new ArrayList<>();
        stn = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int height = Integer.parseInt(stn.nextToken());
            heightList.add(height);
        }
        
        Collections.sort(heightList);

        for(int i=0; i<N; i++) {
            int height = heightList.get(i);
            if(height<=L) {
                L+=1;
            } else {
                break;
            }
        }

        System.out.println(L);
    }
}