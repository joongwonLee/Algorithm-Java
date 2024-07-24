import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer stn = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stn.nextToken());
            int b = Integer.parseInt(stn.nextToken());
            int c = Integer.parseInt(stn.nextToken());
            
            if(a==0&&b==0&&c==0) break;
            
            if(c-b==b-a) {
                System.out.println("AP "+(c+(c-b)));
            } else {
                System.out.println("GP "+(c*(c/b)));
            }
        }
    }
}