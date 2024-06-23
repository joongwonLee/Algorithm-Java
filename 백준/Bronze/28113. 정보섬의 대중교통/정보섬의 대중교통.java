import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int A = Integer.parseInt(stn.nextToken());
        int B = Integer.parseInt(stn.nextToken());

        if(B<A) System.out.println("Subway");
        else if(B==A) System.out.println("Anything");
        else System.out.println("Bus");
    }
}