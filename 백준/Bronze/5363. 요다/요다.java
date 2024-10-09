import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0; i<N; i++) {
            String[] inputArray = br.readLine().split(" ");
            StringBuffer sb = new StringBuffer();
            
            for(int j=2; j<inputArray.length; j++) {
                sb.append(inputArray[j]+" ");
            }
            sb.append(inputArray[0]+" ");
            sb.append(inputArray[1]);
            
            System.out.println(sb);
        }
    }
}