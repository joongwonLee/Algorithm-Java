import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    
    static BufferedReader br;
    
    static int N;
    static BigInteger bi = BigInteger.ONE;
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        char[] factCharArr = String.valueOf(factorial(N)).toCharArray();
        
        int count = 0;
        
        for(int i=factCharArr.length-1; i>=0; i--) {
            if(Integer.parseInt(String.valueOf(factCharArr[i]))==0) count++;
            else break;
        }
        
        System.out.println(count);
    }
    
    public static BigInteger factorial(int N) {
        if(N==0||N==1) return BigInteger.valueOf(1);
        return factorial(N-1).multiply(BigInteger.valueOf(N)); 
    }
}