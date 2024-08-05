import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer stn;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        stn = new StringTokenizer(br.readLine());
        
        BigInteger A = new BigInteger(stn.nextToken());
        BigInteger B = new BigInteger(stn.nextToken());
        
        System.out.println(A.add(B));
    }
}