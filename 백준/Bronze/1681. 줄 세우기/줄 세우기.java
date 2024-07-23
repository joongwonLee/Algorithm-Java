import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stn = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(stn.nextToken());
        int L = Integer.parseInt(stn.nextToken());
        
        int tmp = 0;
        int label = 1;
        while(true) {
            if(!containL(label, L)) tmp++;
            if(tmp==N) break;
            label++;
        }

        System.out.println(label);
    }
    
    static boolean containL(int n, int L) {

        int num = n;

        if(n==L) return true;
        
        while(num>=10) {
            int rest = num%10;
            num /= 10;

            if(rest==L||num==L) return true;
        }

        return false;
    }
}