import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int order = 1;
        
        while(true) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            
            int r = Integer.parseInt(stn.nextToken());
            if(r==0) break;
            
            int w = Integer.parseInt(stn.nextToken());
            int l = Integer.parseInt(stn.nextToken());
            
            String message = "";
            
            if(Math.pow(r, 2)>=Math.pow((double)w/2, 2)+Math.pow((double)l/2, 2)) message = "fits on the table.";
            else message = "does not fit on the table.";
            
            System.out.println("Pizza "+(order++)+" "+message);
        }
    }
}