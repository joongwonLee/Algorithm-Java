import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(stn.nextToken());
            int B = Integer.parseInt(stn.nextToken());
            int C = Integer.parseInt(stn.nextToken());
            int D = Integer.parseInt(stn.nextToken());
            int E = Integer.parseInt(stn.nextToken());
            
            String result = String.format("%.2f",(A*350.34+B*230.90+C*190.55+D*125.30+E*180.90));
            System.out.println("$"+result);
        }
    }
}