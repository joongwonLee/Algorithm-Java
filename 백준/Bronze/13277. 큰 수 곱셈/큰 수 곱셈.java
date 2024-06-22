import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());

        BigInteger b1 = new BigInteger(stn.nextToken());
        BigInteger b2 = new BigInteger(stn.nextToken());

        System.out.println(b1.multiply(b2));
    }
}