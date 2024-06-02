import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numList = new ArrayList<>();
        int sum = 0;
        
        for(int i=0; i<5; i++) {
            int point = Integer.parseInt(br.readLine());
            sum += point;
            numList.add(point);
        }
        
        Collections.sort(numList);
        System.out.println(sum/5);
        System.out.println(numList.get(2));
    }
}