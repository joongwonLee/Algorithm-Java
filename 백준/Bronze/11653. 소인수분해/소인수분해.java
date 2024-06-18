import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        List<Integer> divided = new ArrayList<>();
        
        for(int i=2; i<=N; i++) {
            
            while(N%i==0) {
                N/=i;
                divided.add(i);
            }
        }
        
        for(int num: divided) {
            System.out.println(num);
        }
    }
}