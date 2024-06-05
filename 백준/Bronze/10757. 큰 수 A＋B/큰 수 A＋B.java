import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        BigInteger A = new BigInteger(stn.nextToken());
        BigInteger B = new BigInteger(stn.nextToken());
        
        System.out.println(A.add(B));
    }
}