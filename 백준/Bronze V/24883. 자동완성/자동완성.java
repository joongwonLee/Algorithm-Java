import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br;
    static char c;
    
    public static void main(String[] args) throws IOException {
        
        br = new BufferedReader(new InputStreamReader(System.in));
        c = br.readLine().charAt(0);
        
        if(c=='N'||c=='n') System.out.println("Naver D2");
        else System.out.println("Naver Whale");
    }
}