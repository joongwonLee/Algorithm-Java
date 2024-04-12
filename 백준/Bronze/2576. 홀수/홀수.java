import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static List<Integer> oddList;
    
    static int sum, min;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        oddList = new ArrayList<>();
        sum = 0; min = 0;
        
        for(int i=0; i<7; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number%2!=0) {
                oddList.add(number);
                sum+=number;
            }
        }
        
        if(oddList.size()==0) {
            System.out.println(-1);
        } else {
            Collections.sort(oddList);
            System.out.println(sum);
            System.out.println(oddList.get(0));
        }
    }
}