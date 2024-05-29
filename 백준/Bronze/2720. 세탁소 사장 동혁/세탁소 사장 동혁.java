import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            int C = Integer.parseInt(br.readLine());
            
            int qNum = C/25;
            C%=25;
            int dNum = C/10;
            C%=10;
            int nNum = C/5;
            C%=5;
            int pNum = C;   
            System.out.println(qNum+" "+dNum+" "+nNum+" "+pNum);
        }
    }
}