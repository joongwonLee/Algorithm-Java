import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = br.readLine().substring(0, 5);
        
        int N = Integer.parseInt(br.readLine());
        int sameCount = 0;
        for(int i=0; i<N; i++) {
            String other = br.readLine().substring(0, 5);
            if(code.equals(other)) sameCount++;
        }
        
        System.out.println(sameCount);
    }
}