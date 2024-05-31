import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for(int i=N; i>0; i--) {
            if(isMinsu(i)) {
                System.out.println(i);
                break;
            }
        }
    }
    
    public static boolean isMinsu(int N) {
        char[] numCharArray = String.valueOf(N).toCharArray();
        
        for(int i=0; i<numCharArray.length; i++) {
            int now = Integer.parseInt(String.valueOf(numCharArray[i]));
            if(now!=4&&now!=7) return false;
        }
        return true;
    }
}