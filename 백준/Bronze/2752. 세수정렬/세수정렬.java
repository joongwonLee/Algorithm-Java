import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    static List<Integer> numList;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        numList = new ArrayList<>();
        
        for(int i=0; i<3; i++) {
            int input = Integer.parseInt(stn.nextToken());
            numList.add(input);
        }
        
        Collections.sort(numList);
        
        for(int num: numList) {
            System.out.println(num);
        }
        
    }
}