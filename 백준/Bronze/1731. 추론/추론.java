import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean isMultiple = true;
        boolean isAdd = true;
        List<Integer> numList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            numList.add(input);
        }
        
        for(int i=0; i<N; i++) {
            if(i==0||i==N-1) continue;
            int now = numList.get(i);
            int before = numList.get(i-1);
            int next = numList.get(i+1);
            
            if(now/before!=next/now||now%before!=0||next%now!=0) {
                isMultiple = false;
                break;
            } else if(now-before!=next-now) {
                isAdd = false;
                break;
            }
        }

        int last = numList.get(N-1);
        int lastBefore = numList.get(N-2);
        
        if(isMultiple) {
            System.out.println(last*(last/lastBefore));
        } else {
            System.out.println(last+(last-lastBefore));
        }
    }
}