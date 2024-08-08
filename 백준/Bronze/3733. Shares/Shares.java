import java.util.*;
import java.io.*;

public class Main  {
    
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String str = br.readLine();
            if(str==null) break;
            StringTokenizer stn = new StringTokenizer(str);
            int N = Integer.parseInt(stn.nextToken());
            int S = Integer.parseInt(stn.nextToken());
            
            System.out.println(S/(N+1));
        }
    }
}