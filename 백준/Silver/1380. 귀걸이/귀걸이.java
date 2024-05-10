import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scenario = 1;
        
        while(true) {
            int n = Integer.parseInt(br.readLine());
            
            if(n==0) break;
            
            String[] names = new String[n+1];
            int[] counts = new int[n+1];
            
            for(int i=1; i<=n; i++) {
                String input = br.readLine();
                names[i] = input;
            }
            
            for(int i=0; i<2*n-1; i++) {
                StringTokenizer stn = new StringTokenizer(br.readLine());
                int number = Integer.parseInt(stn.nextToken());
                char ch = stn.nextToken().charAt(0);
                
                counts[number]++;
            }
            
            for(int i=1; i<=n; i++) {
                if(counts[i]==1) {
                    System.out.println(scenario+" "+names[i]);
                    scenario++;
                    break;
                }
            }
        }
    }
}