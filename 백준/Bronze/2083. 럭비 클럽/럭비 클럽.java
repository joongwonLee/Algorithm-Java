import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            
            stn = new StringTokenizer(br.readLine());
            
            String name = String.valueOf(stn.nextToken());
            int age = Integer.parseInt(stn.nextToken());
            int weight = Integer.parseInt(stn.nextToken());
            
            if(name.equals("#")&&age==0&&weight==0) break;
            
            System.out.print(name+" ");
            
            if(age>17||weight>=80) System.out.print("Senior");
            else System.out.print("Junior");
            
            System.out.println();
        }
    }
}