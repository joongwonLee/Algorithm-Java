import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = Integer.MIN_VALUE;
        List<Integer> ropes = new ArrayList<>();
        for(int i=0; i<N; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(ropes, Comparator.reverseOrder());
        
        for(int i=0; i<ropes.size(); i++) {
            result = Math.max(result, (i+1)*ropes.get(i));    
        }

        System.out.println(result);
    }
}