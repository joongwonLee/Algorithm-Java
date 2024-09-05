import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String memo = br.readLine();
        
        int bigDataCount = 0;
        int securityCount = 0;
        
        for(int i=0; i<memo.length(); i++) {
            char now = memo.charAt(i);
            if(now=='b') bigDataCount++;
            else if(now=='s') securityCount++;
        }
        
        if(bigDataCount>securityCount) {
            System.out.println("bigdata?");
        } else if(bigDataCount==securityCount) {
            System.out.println("bigdata? security!");
        } else {
            System.out.println("security!");
        }
    }
}