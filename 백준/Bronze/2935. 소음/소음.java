import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger A = new BigInteger(br.readLine());
        char oper = br.readLine().charAt(0);
        BigInteger B = new BigInteger(br.readLine());
        
        if(oper=='*') {
            System.out.println(A.multiply(B));
        } else if(oper=='+') {
            System.out.println(A.add(B));
        }
    }
}